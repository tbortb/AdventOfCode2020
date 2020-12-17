#include <fstream>
#include <string>
#include <iostream>
#include <vector>
#include <map>

using namespace std;
void solvePartOne(string path);
void solvePartTwo(string path);

int main() {
	solvePartOne("input14.txt");
	solvePartTwo("input14.txt");
	return 0;
}

void solvePartTwo(string path) {
	fstream inputFile;
	inputFile.open(path, ios::in);
	string line;
	unsigned long long onesMask = 0;
	unsigned long long xToZeroMask = 0;
	map<unsigned long long, int> memory;
	vector<unsigned long long> floatings;
	if (inputFile.is_open()) {
		while (getline(inputFile, line)) {
			if (line.substr(0, 7).compare("mask = ") == 0) {
				//Reset masks
				onesMask = 0;
				xToZeroMask = 0;
				floatings.clear();
				int index = 35;
				for (char c : line.substr(7, 36)) {
					if (c == '1') {
						onesMask += pow(2, index);
					}
					else if (c == 'X') {
						xToZeroMask += pow(2, index);
						floatings.push_back(pow(2, index));
					}
					index--;
				}
				//invert zerosMask
				xToZeroMask = ~xToZeroMask;
			}
			else if (line.substr(0, 4).compare("mem[") == 0) {
				//parse value
				int endOfMemAdress = line.find(']');
				unsigned long long memoryAdress = atoi(line.substr(4, endOfMemAdress - 4).c_str());
				long long newValue = atoll(line.substr(endOfMemAdress + 4, line.length() - endOfMemAdress - 4).c_str());

				//apply mask (zerosmask is not necesary, because it should not change anything
				memoryAdress = memoryAdress | onesMask;
				memoryAdress = memoryAdress & xToZeroMask; //set X to zero initially

				//save value in all possible memory adresses
				for (int i = 0; i < pow(2, floatings.size()); i++) {
					unsigned long long newMemoryAdress = memoryAdress;
					for (int x = 0; x < floatings.size(); x++) {
						newMemoryAdress += (floatings[x] * ((i >> x)  & 1U));
					}
					memory[newMemoryAdress] = newValue;
				}
			}
			else {
				cout << "unsupported line: " << line << "\n";
			}
		}

		inputFile.close();
	}

	unsigned long long solutionPartTwo = 0;
	for (pair<unsigned long long, int> element : memory) {
		solutionPartTwo += element.second;
	}

	cout << "Solution to part two: " << solutionPartTwo << "\n";

}

void solvePartOne(string path) {
	fstream inputFile;
	inputFile.open(path, ios::in);
	string line;
	unsigned long long onesMask = 0;
	unsigned long long zerosMask = 0;
	unsigned long long mem[100000] = { 0 };
	if (inputFile.is_open()) {
		while (getline(inputFile, line)) {
			if (line.substr(0, 7).compare("mask = ") == 0) {
				//Reset masks
				onesMask = 0;
				zerosMask = 0;
				int index = 35;
				for (char c : line.substr(7, 36)) {
					if (c == '1') {
						onesMask += pow(2, index);
					}
					else if (c == '0') {
						zerosMask += pow(2, index);
					}
					index--;
				}
				//invert zerosMask
				zerosMask = ~zerosMask;
			}
			else if (line.substr(0, 4).compare("mem[") == 0) {
				//parse value
				int endOfMemAdress = line.find(']');
				int newMemoryAdress = atoi(line.substr(4, endOfMemAdress - 4).c_str());
				long long newValue = atoll(line.substr(endOfMemAdress + 4, line.length() - endOfMemAdress - 4).c_str());

				//apply masks
				newValue = newValue | onesMask;
				newValue = newValue & zerosMask;

				//save in mem array
				mem[newMemoryAdress] = newValue;
			}
			else {
				cout << "unsupported line: " << line << "\n";
			}
		}

		inputFile.close();
	}

	long long solutionPartOne = 0;
	for (long long j : mem) {
		solutionPartOne += j;
	}

	cout << "Solution to part one: " << solutionPartOne << "\n";

}