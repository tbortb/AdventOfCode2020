#include <fstream>
#include <iostream>
#include <string>

using namespace std;
long long calcPartOne(string line);
/*
class Calc {
public:
	bool exists;
	string totalExpression;
	Calc* left;
	Calc* right;
	char opp;

	Calc(string line) {
		exists = true;
		totalExpression = line;
		string term1 = "";
		opp = ' ';
		string term2 = "";

		//trime the line
		if (line[0] == ' ') {
			line = line.substr(1, line.length() - 1);
		}

		bool parseFirst = true;
		bool foundPar = false;
		int parDepth = 0;
		for (char c : line) {
			if (!parseFirst && opp != ' ') {
				//Case opp is set, and not parsing the first element, simply copy char to second element
				term2 += c;
				continue;
			}
			if (c == '(') {
				parDepth++;
				if (parDepth == 1) {
					//throw away the most outer pair of parenthesis (open)
					continue;
				}
				else {
					term1 += c;
				}
			}
			else if (c == ')') {
				parDepth--;
				if (parDepth == 0) {
					parseFirst = false;
					//throw away the most outer pair of parenthesis (close)
					continue;
				}
				else {
					term1 += c;
				}
			}
			else if (c == '+' || c == '*') {
				if (parseFirst && (parDepth == 0)) {
					parseFirst = false;
					opp = c;
				}
				else if (parDepth == 0) {

				}
			}
			else if (c >= 48 && c <= 57) {
				term1 += c;
			}
		}
		if (term2 != "") {
			left = new Calc(term1);
			right = new Calc(term2);
		}
	}

	long long calculate() {
		if (!left) {
			//Case has no child
			return atoll(totalExpression.c_str());
		}
		if (!right) {
			//Case has one child
			return left->calculate();
		}
		switch (opp) {
		case '*':
			return (left->calculate()) * (right->calculate());
			break;
		case '+':
			return (left->calculate()) + (right->calculate());
			break;
		}
	}
};
*/
string prepareForPartTwo(string line);

int main() {
	string path = "input18.txt";
	fstream inputFile;
	inputFile.open(path, ios::in);
	long long solutionPartOne = 0;
	long long solutionPartTwo = 0;
	if (inputFile.is_open()) {
		string line;
		while (getline(inputFile, line)) {
			//Calc equation = Calc(line);
			//solutionPartOne += equation.calculate();
			solutionPartOne += calcPartOne(line);
			solutionPartTwo += calcPartOne(prepareForPartTwo(line));
		}
		inputFile.close();
	}

	cout << "Solution to part one: " << solutionPartOne << "\n";
	cout << "Solution to part two: " << solutionPartTwo << "\n";

	return 0;
}

string prepareForPartTwo(string l) {
	//Idea: surround + opperators with (), so the precedence is the same as in part one
	string line = "";
	int plusses = 0;
	//trime the line
	for (char c : l) {
		if (c != ' ') {
			line += c;
		}
		else if (c == '+') {
			plusses++;
		}
	}

	int workingOnNo = 1;
	for (int index = 0; index < line.length() + plusses; index++) {
		if (line[index] == '+') {
			//insert '('
			int iSub = index;
			int depth = 0;
			do {
				iSub--;
				if (line[iSub] == ')') {
					depth++;
				}
				else if (line[iSub] == '(') {
					depth--;
				}
			} while (depth > 0);
			line.insert(iSub, 1, '(');
			
			//Insert ')'
			iSub = index + 1;
			depth = 0;
			do {
				iSub++;
				if (line[iSub] == ')') {
					depth--;
				}
				else if (line[iSub] == '(') {
					depth++;
				}
			} while (depth > 0);
			line.insert(iSub + 1, 1, ')');
			
			//Increase index an additional time, because exacly one char '(' was inserted before the current index
			index++;
		}
	}
	return line;
}

long long calcPartOne(string l) {
	string line = "";
	//trime the line
	for (char c : l) {
		if (c != ' ') {
			line += c;
		}
	}

	char opp = ' ';
	long long  one = 0;
	long long two = 0;
	string temp = "";

	//The following thing is the fiunction try it out before delete unnecesarry stuff


	int parDepth = 0;
	for (char c : line) {
		if (c == '(') {
			parDepth++;
			if (parDepth == 1) {
				//throw away the most outer pair of parenthesis (open)
				continue;
			}
			else {
				temp += c;
			}
		}
		else if (c == ')') {
			parDepth--;
			if (parDepth == 0) {
				//throw away the most outer pair of parenthesis (close)
				if (one == 0) {
					one = calcPartOne(temp);
				}
				else {
					two = calcPartOne(temp);
				}
				temp = "";
				goto evaluate;
			}
			else {
				temp += c;
			}
		}
		else if (parDepth > 0) {
			temp += c;
			continue;
			//So from here on is only stuff outside ()
		}
		else if (c == '+' || c == '*') {
				opp = c;
			}
		else if (c >= 48 && c <= 57) {
			if (one == 0){
				one = c - 48;
			}
			else {
				two = c - 48;
			}
		}
		evaluate:
		if (two != 0) {
			switch (opp) {
			case '*':
				one *= two;
				break;
			case '+':
				one += two;
				break;

			}
			two = 0;
			opp = ' ';
		}
	}
	return one;
}