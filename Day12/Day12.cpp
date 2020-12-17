#include <stdlib.h>
#include <iostream>
#include <string>
#include <fstream>
#include <vector>

using namespace std;

vector<string> getData(string path) {
	vector<string> lines;
	fstream inputFile;
	inputFile.open(path, ios::in);

	if (inputFile.is_open()) {
		string line;
		while (getline(inputFile, line)) {
			lines.push_back(line);
		}
	}

	inputFile.close();
	return lines;
}

struct command {
public:
	char direction;
	int amount;
};

vector<command> stringToCommand(vector<string> input) {
	vector<command> commands;
	for (string inp : input) {
		command com;
		com.direction = inp[0];
		com.amount = atoi(inp.substr(1, inp.length() - 1).c_str());
		commands.push_back(com);
	}
	return commands;
}

void partOne();
void partTwo();

int main() {
	partOne();
	partTwo();
	

	return 0;
}

void partTwo() {
	vector<string> lines = getData("input12.txt");
	vector<command> commands = stringToCommand(lines);
	int shipNorth = 0;
	int shipEast = 0;
	int wpNorth = 1;
	int wpEast = 10;
	for (command command : commands) {
		switch (command.direction) {
		case 'N':
			wpNorth += command.amount;
			break;
		case 'S':
			wpNorth -= command.amount;
			break;
		case 'E':
			wpEast += command.amount;
			break;
		case 'W':
			wpEast -= command.amount;
			break;
		case 'L':
			for (int i = 0; i < (command.amount / 90); i++) {
				int save = wpEast;
				wpEast = wpNorth * (-1);
				wpNorth = save;
			}
			break;
		case 'R':
			for (int i = 0; i < (command.amount / 90); i++) {
				int save = wpEast;
				wpEast = wpNorth;
				wpNorth = save * (-1);
			}
			break;
		case 'F':
			shipNorth += (command.amount * wpNorth);
			shipEast += (command.amount * wpEast);
			break;
		}
	}

	cout << "Solution to part 2: " << abs(shipNorth) + abs(shipEast) << "\n";
}

void partOne() {
	vector<string> lines = getData("input12.txt");
	vector<command> commands = stringToCommand(lines);
	int north = 0;
	int east = 0;
	char directions[4] = { 'E', 'S', 'W', 'N' };
	int facing = 0;
	for (command command : commands) {
		switch (command.direction) {
		case 'N':
			north += command.amount;
			break;
		case 'S':
			north -= command.amount;
			break;
		case 'E':
			east += command.amount;
			break;
		case 'W':
			east -= command.amount;
			break;
		case 'L':
			if ((command.amount / 90) > 3) {
				cout << command.direction << " " << command.amount << "\n";
			}
			facing -= command.amount / 90;
			while (facing < 0) {
				facing += 4;
			}
			break;
		case 'R':
			if ((command.amount / 90) > 3) {
				cout << command.direction << " " << command.amount << "\n";
			}
			facing += command.amount / 90;
			while (facing > 3) {
				facing -= 4;
			}
			break;
		case 'F':
			switch (directions[facing]) {
			case 'N':
				north += command.amount;
				break;
			case 'S':
				north -= command.amount;
				break;
			case 'E':
				east += command.amount;
				break;
			case 'W':
				east -= command.amount;
				break;
			}
			break;
		}
	}

	cout << "Solution to part 1: " << abs(north) + abs(east) << "\n";
}