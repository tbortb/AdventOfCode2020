#include <fstream>
#include <iostream>
#include <string>
#include <regex>
#include <map>
#include <vector>

using namespace std;

map<int, string> stringToRegex(map<int, string> regExs);

int main() {
	//load data
	string path = "input19.txt";
	string line;
	map<int, string> inputRegExs;
	vector<string> lines;
	fstream inputFile;
	inputFile.open(path, ios::in);
	if(inputFile.is_open()){
		while (getline(inputFile, line)) {
			if (line[0] >= 48 && line[0] <= 57) {
				//It is a rule
				int splitIndex = line.find(':');
				inputRegExs[atoi(line.substr(0, splitIndex).c_str())] = '(' + line.substr(splitIndex + 2, line.length() - splitIndex - 2) + ')';
			}else if(line[0] == 'a' || line[0] == 'b')
				//it is a string to test
				lines.push_back(line);
		}
		inputFile.close();
	}

	map<int, string> rules = stringToRegex(inputRegExs);
	string ruleZero = rules[0];
	int solutionPartOne = 0;
	for (string l : lines) {
		if (regex_match(l, regex(ruleZero))) {
			solutionPartOne++;
		}
	}

	cout << "Solution Part One: " << solutionPartOne << endl;
	return 0;
}

map<int, string> stringToRegex(map<int, string> regExs) {
	vector<bool> parsed(132);
	//set initial values for parsed vector
	for (pair<int, string> p : regExs) {
		for (char c : p.second) {
			if (c == 'a' || c == 'b') {
				parsed[p.first] = true;
				break;
			}
		}
	}

	//update the regex
	bool changed;
	do {
		changed = false;
		for (pair<int, string> p : regExs) {
			if (parsed[p.first]) {
				continue;
			}

			string temp = "";
			int parDepth = 0;
			int i = 0;
			do {
				char c = p.second[i];
				if (c == '(') {
					parDepth++;
				}
				else if (c == ')') {
					parDepth--;
				}
				if (c > 47 && c < 58) {
					temp += c;
				}
				else if (c == ' ' || (c == ')' && temp != "") /*EOL*/) {
					if (c == ' ') {
						temp += c;
					}
					//Check if the rule in question is parsed already
					if (parsed[atoi(temp.c_str())]) {
						string rule = regExs[p.first];
						string newRule = rule.replace(rule.find(temp), temp.length(), regExs[atoi(temp.c_str())]);
						regExs[p.first] = newRule;
					}
					temp = "";
				}
				i++;
			} while (parDepth > 0);

			//check if this rule has been parsed completely
			bool finishedParsing = true;
			for (char ch : regExs[p.first]) {
				if (ch > 47 && ch < 58) {
					finishedParsing = false;
					break;
				}
			}
			if (finishedParsing) {
				parsed[p.first] = true;
			}
			if (!changed) {
				changed = finishedParsing;
			}
		}
	} while (changed);

	//Throw out leftover spaces from rule zero
	string ruleZero = regExs[0];
	regExs[0] = "";
	for (char c : ruleZero) {
		if (c == ' ') {
			continue;
		}
		regExs[0] += c;
	}

	return regExs;
}
















