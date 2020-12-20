#define SIZE 22
#define INPUTSIZE 8
#define ROUNDS 6
#include <fstream>
#include <iostream>
#include <string>

using namespace std;
void print3DSpace(int arr[SIZE][SIZE][SIZE]);
void doPartOne();
void doPartTwo();

int main() {
	doPartOne();
	doPartTwo();
	return 0;
}

void doPartTwo() {
	//Load Data
	static int space[SIZE][SIZE][SIZE][SIZE] = { 0 };
	string path = "input17.txt";
	fstream inputFile;
	inputFile.open(path, ios::in);
	if (inputFile.is_open()) {
		string line;
		int lineNo = 0;
		while (getline(inputFile, line)) {
			int charNo = 0;
			for (char c : line) {
				if (c == '#') {
					space[(SIZE - INPUTSIZE) / 2 + lineNo][(SIZE - INPUTSIZE) / 2 + charNo][SIZE / 2][SIZE / 2] = 1;
				}
				charNo++;
			}
			lineNo++;
		}
	}


	//Play Game part one
	static int newSpace[SIZE][SIZE][SIZE][SIZE] = { 0 };
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			for (int k = 0; k < SIZE; k++) {
				for (int l = 0; l < SIZE; l++) {
					newSpace[i][j][k][l] = space[i][j][k][l];
				}
			}
		}
	}
	for (int round = 0; round < ROUNDS; round++) {
		//cout << "Runde " << round << "\n";
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					for (int l = 0; l < SIZE; l++) {
						//Check neighbours
						int activeNeighbours = 0;
						for (int io = -1; io <= 1; io++) {
							if (((i + io) >= SIZE) || ((i + io) < 0)) {
								continue;
							}
							for (int jo = -1; jo <= 1; jo++) {
								if (((j + jo) >= SIZE) || ((j + jo) < 0)) {
									continue;
								}
								for (int ko = -1; ko <= 1; ko++) {
									if (((k + ko) >= SIZE) || ((k + ko) < 0)) {
										continue;
									}
									for (int lo = -1; lo <= 1; lo++) {
										if (((l + lo) >= SIZE) || ((l + lo) < 0) ||
											(io == 0 && jo == 0 && ko == 0 && lo == 0)) {
											continue;
										}
										if (space[i + io][j + jo][k + ko][l + lo]) {
											activeNeighbours++;
										}
									}
								}
							}
						}
						if (space[i][j][k][l] && ((activeNeighbours < 2) || (activeNeighbours > 3))) {
							//cout << "aus\n";
							newSpace[i][j][k][l] = 0;
						}
						if ((!space[i][j][k][l]) && (activeNeighbours == 3)) {
							//cout << "ein\n";
							newSpace[i][j][k][l] = 1;
						}
					}
				}
			}
		}
		//copy space for next round
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					for (int l = 0; l < SIZE; l++) {
						space[i][j][k][l] = newSpace[i][j][k][l];
					}
				}
			}
		}
	}

	//Count active cubes
	long long solutionPartTwo = 0;
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			for (int k = 0; k < SIZE; k++) {
				for (int l = 0; l < SIZE; l++) {
					if (space[i][j][k][l]) {
						solutionPartTwo++;
					}
				}
			}
		}
	}
	cout << "Solution Part two: " << solutionPartTwo << "\n";


}

void doPartOne() {
	//Load Data
	int space[SIZE][SIZE][SIZE] = { 0 };
	string path = "input17.txt";
	fstream inputFile;
	inputFile.open(path, ios::in);
	if (inputFile.is_open()) {
		string line;
		int lineNo = 0;
		while (getline(inputFile, line)) {
			int charNo = 0;
			for (char c : line) {
				if (c == '#') {
					space[(SIZE - INPUTSIZE) / 2 + lineNo][(SIZE - INPUTSIZE) / 2 + charNo][SIZE / 2] = 1;
				}
				charNo++;
			}
			lineNo++;
		}
	}


	//Play Game part one
	int newSpace[SIZE][SIZE][SIZE] = { 0 };
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			for (int k = 0; k < SIZE; k++) {
				newSpace[i][j][k] = space[i][j][k];
			}
		}
	}
	//copy(begin(space), end(space), begin(newSpace));
	for (int round = 0; round < ROUNDS; round++) {
		//cout << "Runde " << round << "\n";
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					//Check neighbours
					int activeNeighbours = 0;
					for (int io = -1; io <= 1; io++) {
						if (((i + io) >= SIZE) || ((i + io) < 0)) {
							continue;
						}
						for (int jo = -1; jo <= 1; jo++) {
							if (((j + jo) >= SIZE) || ((j + jo) < 0)) {
								continue;
							}
							for (int ko = -1; ko <= 1; ko++) {
								if (((k + ko) >= SIZE) || ((k + ko) < 0) ||
									(io == 0 && jo == 0 && ko == 0)) {
									continue;
								}
								if (space[i + io][j + jo][k + ko]) {
									activeNeighbours++;
								}
							}
						}
					}
					if (space[i][j][k] && ((activeNeighbours < 2) || (activeNeighbours > 3))) {
						//cout << "aus\n";
						newSpace[i][j][k] = 0;
					}
					if ((!space[i][j][k]) && (activeNeighbours == 3)) {
						//cout << "ein\n";
						newSpace[i][j][k] = 1;
					}
				}
			}
		}
		for (int i = 0; i < SIZE; i++) {
			for (int j = 0; j < SIZE; j++) {
				for (int k = 0; k < SIZE; k++) {
					space[i][j][k] = newSpace[i][j][k];
				}
			}
		}
	}

	//Count active cubes
	long long solutionPartOne = 0;
	for (int i = 0; i < SIZE; i++) {
		for (int j = 0; j < SIZE; j++) {
			for (int k = 0; k < SIZE; k++) {
				if (space[i][j][k]) {
					solutionPartOne++;
				}
			}
		}
	}
	cout << "Solution Part one: " << solutionPartOne << "\n";
}

void print3DSpace(int arr[SIZE][SIZE][SIZE]) {
	//Print data
	for (int k = 0; k < SIZE; k++) {
		cout << "Ebene " << k << "\n";
		for (int j = 0; j < SIZE; j++) {
			for (int i = 0; i < SIZE; i++) {
				cout << arr[j][i][k] << " ";
			}
			cout << "\n";
		}
	}
}