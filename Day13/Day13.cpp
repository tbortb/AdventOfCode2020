#include <iostream>
#include <string>
#include <fstream>
#include <vector>
#include <cmath>
#include <math.h>

using namespace std;

string readLine(string path, int lineNo) {
	fstream inputFile;
	inputFile.open(path, ios::in);
	string output;
	string dontCare;

	if (inputFile.is_open()) {
		for (int i = 0; i <= lineNo; i++) {
			if (i == lineNo) {
				getline(inputFile, output);
			}
			else {
				getline(inputFile, dontCare);
			}
		}
		inputFile.close();
	}

	return output;
}


long long xGCD(long long a, long long b, long long& x, long long& y) {
	//Function from stack overflow https://stackoverflow.com/questions/12826114/euclids-extended-algorithm-c
	//a muss größer als b sein
	if (b == 0) {
		x = 1;
		y = 0;
		return a;
	}

	long long x1, y1, gcd = xGCD(b, a % b, x1, y1);
	x = y1;
	y = x1 - (a / b) * y1;
	return gcd;
}

vector<long long> strToIntVec(string str);
vector<long long>getOffsets(string str);
long long solvePartTwo(vector<long long> busses, vector<long long> offsets);
void printVec(string name, vector<long long> v);

int main() {
	//parse input
	string inputPath = "input13.txt";
	int earliest = atoi(readLine(inputPath, 0).c_str());
	string busString = readLine(inputPath, 1);
	vector<long long> busses = strToIntVec(busString);

	//Part 1
	int time = earliest;
	
	while (true) {
		for (int busNo : busses) {
			if (time % busNo == 0) {
				cout << "Solution Part No One: " << (time - earliest) * busNo << "\n";
				goto endPartOne;
			}
		}
		time++;
	}
	endPartOne:

	
	//Part Two
	//All input numbers are prime numbers
	//Result > 10^13
	long long start = 0;
	bool found = false;
	vector<long long> offsets = getOffsets(busString);
	int magnitude = 1;
	/*
	while (!found) {
		ifFailed:
		start += busses[0];
		if ((start % 100000) == 0) {
			if (magnitude != floor(log10(start))) {
				magnitude = floor(log10(start));
				cout << "Magnitude: " << magnitude << "\n";
			}
		}
		for (int i = 0; i < busses.size(); i++) {
			if (((start + offsets[i]) % busses[i]) != 0) {
				goto ifFailed;
			}
		}
		found = true;
	}

	*/
	long long solutionPartTwo = solvePartTwo(busses, offsets);
	//-4385290 is too small
	//16759532893322057 is wrong
	// it is 894954360381385
	cout << "Solution to part 2: " << solutionPartTwo << "\n";
	
	//Test from Stackoverflow
	/*
	int a = 99, b = 78, x, y, gcd;
	gcd = xGCD(a, b, x, y);
	std::cout << "GCD: " << gcd << ", x = " << x << ", y = " << y << std::endl;
	*/
	return 0;
}

void printVec(string name, vector<long long> v) {
	cout << name << ": ";
	for (long long n : v) {
		cout << n << " ";
	}
	cout << "\n";
}

long long solvePartTwo(vector<long long> busses, vector<long long> offsets) {
	//https://de.wikipedia.org/wiki/Chinesischer_Restsatz
	//Max Wert von long long ist d9223372036854775807
	//first create remainders
	long long answer = 0;
	vector<long long> remainders;
	for (int i = 0; i < busses.size(); i++) {
		int offset = offsets[i];
		int bus = busses[i];
		while (offset > bus) {
			offset -= bus;
		}
		if (offset == 0) {
			remainders.push_back(0);
		}
		else {
			remainders.push_back(bus - offset);
		}
	}

	printVec("Busses", busses);
	printVec("Offsets", offsets);
	printVec("Remainders", remainders);

	long long M = 1;
	for (int m : busses) {
		M *= m;
	}
	cout << "M: " << M << "\n";


	//Create vector of multiplicators (s on wikipedia)
	vector<long long> multiplicators;//'s' on wikipedia
	for (int i = 0; i < busses.size(); i++) {
		long long x, y, gcd;
		if ((M / busses[i]) > busses[i]) {
			gcd = xGCD(M / busses[i], busses[i], x, y);
		}
		else {
			gcd = xGCD(busses[i], M / busses[i], x, y);
		}

		multiplicators.push_back(x * M/busses[i]);
	}

	cout << "Multiplicators: ";
	for (long long m : multiplicators) {
		cout << m << " ";
	}
	cout << "\n";

	for (int i = 0; i < busses.size(); i++) {
		answer += remainders[i] * multiplicators[i];
	}

	while (answer < 0) {
		cout << answer << " is too small" << "\n";
		answer += M;
	}

	while (answer > M) {
		cout << answer << " is too large" << "\n";
		answer -= M;
	}

	return answer;
}

vector<long long> strToIntVec(string str) {
	vector<long long> arr;
	vector<char> ints{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0'};
	string temp = "";
	for (char c : str) {
		if (find(ints.begin(), ints.end(), c) != ints.end()) {
			temp += c;
		}
		else {
			if (temp.length() > 0) {
				arr.push_back(atoll(temp.c_str()));
				temp = "";
			}
		}
	}
	//In case the last element was also a bus, not followed by anything else
	if (temp.length() > 0) {
		arr.push_back(atoll(temp.c_str()));
	}

	return arr;
}

vector<long long>getOffsets(string str) {
	vector<long long> arr;
	vector<char> ints{ '1', '2', '3', '4', '5', '6', '7', '8', '9', '0' };
	string temp = "";
	vector<long long> offsets;
	int offset = 0;
	for (char c : str) {
		if (find(ints.begin(), ints.end(), c) != ints.end()) {
			temp += c;
		}
		else {
			if (temp.length() > 0) {
				arr.push_back(atoll(temp.c_str()));
				offsets.push_back(offset);
				temp = "";
			}
			if (c == ',') {
				offset++;
			}
		}
	}
	//In case the last element was also a bus, not followed by anything else
	if (temp.length() > 0) {
		arr.push_back(atoi(temp.c_str()));
		offsets.push_back(offset);
	}

	return offsets;
}