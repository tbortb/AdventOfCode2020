#define SIZE 104
#include <iostream>
#include <fstream>
#include <string>
#include <algorithm>

using namespace std;

int mapToFactor(int consecutive);

int main() {
	fstream inputFile;
	inputFile.open("input10.txt", ios::in);
	
	int numbers[SIZE];

	if (inputFile.is_open()) {
		int lineNumber = 0;
		string line;
		while (getline(inputFile, line)) {
			numbers[lineNumber] = atoi(line.c_str());
			lineNumber++;
		}
	}
	//Part 1
	//Observation: The difference is always 1 or 3
	sort(numbers, numbers + SIZE);

	int oneDiffCount = 1; //min is 1, so the difference between  outlet ant first adapter is 1
	int threeDiffCount = 1; //diff from max adapter to device

	for (int index = 0; index < SIZE - 1; index++) {
		int diff = numbers[index + 1] - numbers[index];
		switch (diff) {
		case 1:
			oneDiffCount++;
			break;
		case 3:
			threeDiffCount++;
			break;
		default:
			cout << "gap between " << numbers[index] << " and " << numbers[index + 1] << "\n";
		}
	}

	cout << "Solution to part 1: " << oneDiffCount * threeDiffCount << "\n";

	//Part 2
	//Every time the adapters have a difference of three, the chain can be slit into 
	//two parts whos results can be multiplied, because they are independent of one another

	//No adapter multipl

	//Another question is when does an adapter become essential for the line?
	//In the end I made the following formular:
	//Since there is no gap of 2 jolte, i only count the number of consecutive
	//joltages, except for the ones following or followed by a 3 jolte gap.
	// 1 -> *2, 2 -> *4, 3 -> *7, 4 -> *13, 5 -> *24 (numbers found experimentally)

	long long combinations = 1;
	int consecutive = 1; //Smallest number is a 1
	for (int lineNumber = 1; lineNumber < SIZE; lineNumber++) {
		if ((numbers[lineNumber] - numbers[lineNumber - 1]) == 1) {
			consecutive++;
		}
		else if ((numbers[lineNumber] - numbers[lineNumber - 1]) == 3) {
			if (consecutive > 0) {
				combinations *= mapToFactor(--consecutive);
				consecutive = 0;
			}
		}
		else {
			cout << "Gap neither 1, nor 3" << "\n";
		}
	}
	//Gap to charger is 3
	if (consecutive > 0) {
		combinations *= mapToFactor(--consecutive);
		consecutive = 0;
	}

	//1277551356655694848 is too high
	//1322306994176 is too low
	cout << "Solution to part 2: " << combinations << "\n";



	return 0;
}

int mapToFactor(int consecutive) {
	switch(consecutive) {
		case 0:
			return 1;
		case 1:
			return 2;
		case 2:
			return 4;
		case 3:
			return 7;
		case 4:
			return 13;
		case 5:
			return 24;
	}
}