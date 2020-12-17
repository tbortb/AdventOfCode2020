#include <iostream>
#include <fstream>
#include <string>
#include <map>

using namespace std;
map<int, int> readInput(string path);
map<int, int> lineToMap(string line);
int solvePartOne(map<int, int> mem);
int solvePartTwo(map<int, int> mem, int limit);

int main() {
	map<int, int> mem = readInput("input15.txt");

	int solutionPartOne = solvePartOne(mem);
	cout << "Solution for part one: " << solutionPartOne << "\n";

	int solutionPartTwo = solvePartTwo(mem, 30000000);
	cout << "Solution for part two: " << solutionPartTwo << "\n";

	return 0;
}

int solvePartTwo(map<int, int> mem, int limit) {

	int nextNumber = 0;
	int currentNumber = 0;
	for (int round = mem.size(); round < limit; round++) {
		if ((round % 1000000) == 0) {
			cout << "Playing round: " << round << "\n";
		}
		currentNumber = nextNumber;
		nextNumber = mem.count(currentNumber) == 1 ? round - mem[currentNumber] : 0;
		mem[currentNumber] = round;
	}

	return currentNumber;
}

int solvePartOne(map<int, int> mem) {
	//maybe easier with array --> convert map to array (only works if there are no duploicate values in the input)
	int hist[2020] = { 0 };
	for (pair<int, int> element : mem) {
		hist[element.second] = element.first;
	}

	for (int round = mem.size(); round < 2020; round++) {
		int lastNum = hist[round - 1];
		//Check if lastNum was "said" before
		bool found = false;
		for (int testIndex = round - 2; testIndex >= 0; testIndex--) {
			if (lastNum == hist[testIndex]) {
				hist[round] = round - testIndex - 1;
				found = true;
				break;
			}
		}
		//In case the number was not used before, "say" 0
		if (!found) {
			hist[round] = 0;
		}
		//cout << "LastNum: " << lastNum << " Round: " << round << " Say: " << hist[round] << "\n";

	}
	return hist[2019];
}

map<int, int> readInput(string path) {
	fstream inputFile;
	map<int, int> mem;

	inputFile.open(path, ios::in);
	if (inputFile.is_open()) {
		string line;
		getline(inputFile, line);
		mem = lineToMap(line);

		inputFile.close();
	}
	return mem;
}

map<int, int> lineToMap(string line) {
	map<int, int> mem;
	string newNum;
	int lastUsedAt = 0;
	for (char c : line) {
		if (c >= 48 && c <= 57) {
			newNum += c;
		}
		else if (c == ',') {
			int value = atoi(newNum.c_str());
			mem[value] = lastUsedAt++;
			newNum = "";
		}
	}
	//Dont forget the last number
	int value = atoi(newNum.c_str());
	mem[value] = lastUsedAt;

	return mem;
}