#include <iostream>
#include <fstream>
#include <string>

#define SIZE 1000

using namespace std;

int main() {
	long long numbers[SIZE] = {0};
	fstream inputFile;
	inputFile.open("input09.txt", ios::in);
	
	if (inputFile.is_open()) {
		string line;
		int lineNumber = 0;
		while (getline(inputFile, line)) {
			numbers[lineNumber] = stoll(line);
			lineNumber++;
		}
	}

	//Part One
	long long solutionPartOne;
	for (int line = 25; line < SIZE; line++) {
		bool check = false;
		for (int upperLine = line - 25; upperLine < line; upperLine++) {
			for (int lowerLine = upperLine + 1; lowerLine < line; lowerLine++) {
				if (numbers[upperLine] + numbers[lowerLine] == numbers[line]) {
					check = true;
				}
			}
		}

		if (!check) {
			solutionPartOne = numbers[line];
			cout << "Solution to part 1: " << numbers[line] << "\n";
			break;
		}
	}

	//Part Two
	for (int start = 0; start < SIZE; start++) {
		long long sum = numbers[start];
		long long smallest = sum;
		long long largest = sum;
		int offset = 1;
		while (sum < solutionPartOne) {
			//update sum, smallest and largest
			sum += numbers[start + offset];
			if (numbers[start + offset] < smallest) {
				smallest = numbers[start + offset];
			}
			else if (numbers[start + offset] > largest) {
				largest = numbers[start + offset];
			}
			//check
			if (sum == solutionPartOne) {
				//53870729 is to low
				long long solutionPartTwo = smallest + largest;
				cout << "Found solution from line " << start << " to line " << start + offset << "\n";
				cout << "With smallest: " << smallest << " and largest: " << largest << "\n";
				cout << "Solution to part 2: " << solutionPartTwo << "\n";
			}
			//increase
			offset++;
		}
	}
	return 0;
}
