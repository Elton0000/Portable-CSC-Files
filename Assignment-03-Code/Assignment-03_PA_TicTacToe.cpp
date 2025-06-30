#include <iostream>
#include <string>
using namespace std;

bool isWon(char input, char board[][3]) {
	//O = 79 // X = 88  // 5X, 4O = 756
	bool won = false;
	
	
	

	return won;
}

bool isDraw(char board[][3]) {
	int total = 0;
	for (int i = 0; i < sizeof(*board); i++) {//row 0 -> 3 transition
		for (int j = 0; j < sizeof(board[i]); j++) {//column to column 0 ->3 // top left to bottom right
			if (board[i][j] != ' ') {
				total += board[i][j];
			}
		}
	}
	return total == 747 || total == 756; //sum of combination of X and Os
}

void displayBoard(char board[][3]) {
	string lines = "-------";
	
	for (int i = 0; i < sizeof(*board); i++) {//row 0 -> 3 transition
		cout << lines << "\n";
		for (int j = 0; j < sizeof(board[i]); j++) {//column to column 0 ->3 // top left to bottom right
			cout << "|" << board[i][j];
		}
		cout << "|\n";
	}
	cout << lines << "\n";
}

void makeAMove(char board[][3], char currentPlayer) {
	int input[2];
	cout << board[0];
	cout << "Enter a row (0, 1, 2) for player " << currentPlayer << ": ";

	while (!(cin >> input[0]) || (input[0] != 0 && input[0] != 1 && input[0] != 2)) {
		cin.clear();
		cin.ignore();
		cout << "Incorrect input. Please try again.\n";
		cout << "Enter a row (0, 1, 2) for player " << currentPlayer << ": ";
	}

	cout << "Enter a column (0, 1, 2) for player " << currentPlayer << ": ";
	while (!(cin >> input[1]) || (input[1] != 0 && input[1] != 1 && input[1] != 2)) {
		cin.clear();
		cin.ignore();
		cout << "Incorrect input. Please try again.\n";
		cout << "Enter a column (0, 1, 2) for player " << currentPlayer << ": ";
	}

	if (board[input[0]][input[1]] != ' ') {
		cout << "This cell is already occupied. Try a different cell.\n";
			makeAMove(board, currentPlayer);
	}
	else {
		board[input[0]][input[1]] = currentPlayer;
	}
}

int main() {
	//
	//	PLEASE DO NOT CHANGE function main
	//
	char board[3][3] = { { ' ', ' ', ' ' },{ ' ', ' ', ' ' },{ ' ', ' ', ' ' } };
	displayBoard(board);
	
	while (true) {

		// The first player makes a move
		makeAMove(board, 'X');
		displayBoard(board);
		
		if (isWon('X', board)) {
			cout << "X player won" << endl;
			exit(0);
		}
		else if (isDraw(board)) {
			cout << "No winner" << endl;
			exit(0);
		}

		// The second player makes a move
		makeAMove(board, 'O');
		displayBoard(board);

		if (isWon('O', board)) {
			cout << "O player won" << endl;
			exit(0);
		}
		else if (isDraw(board)) {
			cout << "No winner" << endl;
			exit(0);
		}
		
	}

	return 0;
}