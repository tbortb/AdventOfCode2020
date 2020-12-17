#include <iostream>
#include <fstream>
#include <string>
#include <vector>

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
	string path = "testinput16_2.txt";
	
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
	/*Print data:
	for (rule r : rules) {
		cout << "Name: " << r.name << " Min1: " << r.intervalOneMin << " Max1: " << r.intervalOneMax << " Min2: " << r.intervalTwoMin << " Max2: " << r.intervalTwoMax << "\n";
	}

	for (int i : myTicket.data) {
		cout << i << " ";
	}
	cout << "\n";
	for (ticket t : nearbyTickets) {
		for (int i : t.data) {
			cout << i << " ";
		}
		cout << "\n";
	}
	*/

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

	/*
	//Print nearbyTicket validity:
	for (ticket t : nearbyTickets) {
		coplüut << t.isValid << " ";
	}
	cout << "\n";
	*/

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