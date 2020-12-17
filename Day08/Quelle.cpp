#include <iostream>
#include <fstream>
#include <string>
using namespace std;
int main() {
	fstream inputFile;
	inputFile.open("input08.txt", ios::in);

	//Create arrays for data
	string instructions[623];
	int quantities[623];
	bool visited[623];
	bool visitedPart2[623];
	bool triedToChange[623];
	for (int index = 0; index < 623; index = index + 1) {
		instructions[index] = "";
		quantities[index] = 0;
		visited[index] = false;
		visitedPart2[index] = false;
		triedToChange[index] = false;
	}

	//Read inputFile
	int lineNumber = 0;
	if (inputFile.is_open()) {
		string line;
		while (getline(inputFile, line)) {

			instructions[lineNumber] = line.substr(0, 3);
			quantities[lineNumber] = atoi(line.substr(4, line.length() - 4).c_str());
			lineNumber++;
		}
		inputFile.close();
	}

	//Part one
	int acc = 0;
	int lineNr = 0;
	while (visited[lineNr] == 0) {
		visited[lineNr] = true;
		if (instructions[lineNr].compare("acc") == 0) {
			acc += quantities[lineNr];
			lineNr++;
		}
		else if (instructions[lineNr].compare("nop") == 0) {
			lineNr++;
		}
		else if (instructions[lineNr].compare("jmp") == 0) {
			lineNr += quantities[lineNr];
		}
		else {
			cout << instructions[lineNr];
		}
	}

	cout << "Solution to part one: " << acc << "\n";


	//Part 2: Approach, change the first nop/jmp and try if it works,
	//if it does not work, return to the start and chnge the first nop/jmp that
	//has never been changed
	int lineNrPart2 = 0;
	int accPart2 = 0;
	while (lineNrPart2 < 623) {
		lineNrPart2 = 0;
		accPart2 = 0;
		bool changedSomething = false;
		while ((visitedPart2[lineNrPart2] == 0) && (lineNrPart2 < 623)) {
			visitedPart2[lineNrPart2] = true;
			if (instructions[lineNrPart2].compare("acc") == 0) {
				accPart2 += quantities[lineNrPart2];
				lineNrPart2++;
			}
			else if (instructions[lineNrPart2].compare("nop") == 0) {
				if ((changedSomething == 0) && !triedToChange[lineNrPart2]) {
					changedSomething = true;
					triedToChange[lineNrPart2] = true;
					lineNrPart2 += quantities[lineNrPart2];
				}
				else {
					lineNrPart2++;
				}
			}
			else if (instructions[lineNrPart2].compare("jmp") == 0) {
				if ((changedSomething == 0) && !triedToChange[lineNrPart2]) {
					changedSomething = true;
					triedToChange[lineNrPart2] = true;
					lineNrPart2++;
				}
				else {
					lineNrPart2 += quantities[lineNrPart2];
				}
			}
			else {
				cout << instructions[lineNrPart2];
			}
		}

		//Reset visited array
		for (int index = 0; index < 623; index = index + 1) {
			visitedPart2[index] = false;
		}
	}

	cout << "Solution to part two: " << accPart2 << "\n";

	return 0;
}