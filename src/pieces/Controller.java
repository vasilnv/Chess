package pieces;

import java.util.Scanner;

import pieces.Chessboard;

public class Controller {
	
	static Scanner user_input = new Scanner(System.in);

	
	public static void main(String[] args) {
		Chessboard chessboard = new Chessboard();
		chessboard.printBoard();
		Move currMove = new Move(chessboard);
		while (Chessboard.gameRunning) {
			chessboard.printBoard();
			currMove.move();
		}
	}

}
