#include <iostream>
#include <fstream>
#include <string>
#include <vector>
#include <map>

using namespace std;

struct rule {
	string name;
	int intervalOneMin = -1;
	int intervalOneMax = -1;
	int intervalTwoMin = -1;
	int intervalTwoMax = -1;
};

struct ticket {
	vector<int> data;
	bool isValid = true;
};

rule parseRule(string line);
ticket parseTicket(string line);

int main() {
	string path = "input16.txt";
	
	vector<rule> rules;
	ticket myTicket;
	vector<ticket> nearbyTickets;
	
	fstream inputFile;
	inputFile.open(path, ios::in);
	if (inputFile.is_open()) {
		string part = "rules";
		string line;
		while (getline(inputFile, line)) {
			if (line == "your ticket:" || line == "nearby tickets:") {
				part = line;
				continue;
			}
			if (line == "") {
				continue;
			}

			if (part == "rules") {
				rules.push_back(parseRule(line));
			}
			else if (part == "your ticket:"){
				myTicket = parseTicket(line);
			}
			else if (part == "nearby tickets:") {
				nearbyTickets.push_back(parseTicket(line));
			}
		}
		inputFile.close();
	}

	int solutionPartOne = 0;
	for (ticket &t : nearbyTickets) {
		for (int value : t.data) {
			bool matchesRule = false;
			for (rule r : rules) {
				if ((value >= r.intervalOneMin && value <= r.intervalOneMax) ||
					(value >= r.intervalTwoMin && value <= r.intervalTwoMax)) {
					matchesRule = true;
					break;
				}
			}
			if (!matchesRule) {
				solutionPartOne += value;
				t.isValid = matchesRule;
			}
		}
	}

	cout << "Solution to Part one: " << solutionPartOne << "\n";

	//Part Two
	map<string, int> mapping;
	for (rule r : rules) {
		mapping[r.name] = -1;
	}

	vector<map<string, bool>> possibleFields;
	for (int i = 0; i < myTicket.data.size(); i++) {
		map<string, bool> f;
		for (rule r : rules) {
			f[r.name] = true;
		}
		possibleFields.push_back(f);
	}

	bool changed;
	do {
		changed = false;
		for (int i = 0; i < myTicket.data.size(); i++) {
			//Skip column if it has a fix field already
			bool skipCol = false;
			for (pair<string, int> p : mapping) {
				if (p.second == i) {
					skipCol = true;
					break;
				}
			}
			if (skipCol) {
				continue;
			}
			for (ticket t : nearbyTickets) {
				if (!t.isValid) {
					continue;
				}
				int d = t.data[i];
				for (rule r : rules) {
					if (!((d >= r.intervalOneMin && d <= r.intervalOneMax) ||
						(d >= r.intervalTwoMin && d <= r.intervalTwoMax)) || 
						((mapping[r.name] > -1) && (mapping[r.name] != i))) {
						possibleFields[i][r.name] = false;
					}
				}
			}

			//Count how many fields are possible for this index
			string possibleField;
			int countPossibleFields = 0;
			for (pair<string, bool> el : possibleFields[i]) {
				if (el.second) {
					countPossibleFields++;
					possibleField = el.first;
				}
			}
			if (countPossibleFields == 1) {
				mapping[possibleField] = i;
				changed = true;
			}
		}
	} while (changed);


	long long solutionPartTwo = 1;
	for (pair<string, int> p : mapping) {
		if (p.first.substr(0, 9).compare("departure") == 0) {
			solutionPartTwo *= myTicket.data[p.second];
		}
	}
	cout << "Solution to part two: " << solutionPartTwo << "\n";

	return 0;
}

rule parseRule(string line) {
	rule rule;
	string temp = "";
	for (char c : line) {
		if (c == ':') {
			rule.name = temp;
			temp = "";
			continue;
		}
		else if (c == '-') {
			if (rule.intervalOneMin == -1) {
				rule.intervalOneMin = atoi(temp.c_str());
			}
			else {
				rule.intervalTwoMin = atoi(temp.c_str());
			}
			temp = "";
			continue;
		}
		else if (c == ' ') {
			if (temp == "" || temp == "or") {
				temp = "";
				continue;
			}
			else if (rule.intervalOneMax == -1) {
				rule.intervalOneMax = atoi(temp.c_str());
			}
			temp = "";
			continue;
		}
		else {
			temp += c;
		}
	}
	rule.intervalTwoMax = atoi(temp.c_str());
	return rule;
}

ticket parseTicket(string line) {
	ticket ticket;
	string temp = "";
	for (char c : line) {
		if (c == ',') {
			ticket.data.push_back(atoi(temp.c_str()));
			temp = "";
		}
		else if (c >= 48 && c <= 57) {
			temp += c;
		}
	}
	ticket.data.push_back(atoi(temp.c_str()));
	return ticket;
}