package pieces;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

import pieces.AbstractPiece;

/**
 * An 8x8 Chessboard with a console display and string user input Has some basic
 * rules for checking if a move is valid or not Keeps track of the score of each
 * player by the value of pieces they take For best results construct a
 * Chessboard(), call move() and call printBoard().
 * 
 * @author SamiStart
 *
 */

public class Chessboard {

	private Boolean gameRunning;
	private AbstractPiece[][] chessboard = new AbstractPiece[numOfRowsAndCols][numOfRowsAndCols];// [row][column]
	Scanner user_input = new Scanner(System.in);
	private static final int numOfRowsAndCols = 8;
	private static int sourceRow, sourceColumn, destinationRow, destinationColumn;
	private static int whiteScore = 0, blackScore = 0;
	private static Boolean whitesTurnToMove;
	private static Boolean invalidMove = false;
	String moveCommand;

	public Chessboard() {
		initialiseBoard(chessboard);
		gameRunning = true;
	}

	/**
	 * This gets attribute Boolean gameRunning if this is false then you should
	 * stop calling move() and printBoard() and close the Chessboard()
	 * 
	 * @return a Boolean that is false if the user wants to exit called
	 *         gameRunning
	 */
	public Boolean getGameRunning() {
		return this.gameRunning;
	}

	public static void assignWhoStartsFirst() {
		// Randomly assign who starts first (black or white)
		Random rand = new Random();
		whitesTurnToMove = rand.nextBoolean();
	}

	/**
	 * Populates the chessboard of AbstractPiece with the correct pieces and
	 * randomly assigns whether white or black moves first
	 * 
	 * @param chessboard
	 */
	private static void initialiseBoard(AbstractPiece[][] chessboard) {
		// a chessboard with 8x8 matrix of pieces
		// rows [0] and [1] are black
		// rows [6] and [7] are white

		for (int row = 0; row < chessboard.length; row++) {
			for (int column = 0; column < chessboard[row].length; column++) {
				if (row == 0) {
					switch (column) {
					case 0:
						chessboard[row][column] = new Rook(false);
						break;
					case 1:
						chessboard[row][column] = new Knight(false);
						break;
					case 2:
						chessboard[row][column] = new Bishop(false);
						break;
					case 3:
						chessboard[row][column] = new Queen(false);
						break;
					case 4:
						chessboard[row][column] = new King(false);
						break;
					case 5:
						chessboard[row][column] = new Bishop(false);
						break;
					case 6:
						chessboard[row][column] = new Knight(false);
						break;
					case 7:
						chessboard[row][column] = new Rook(false);
						break;
					}
				} else if (row == 1) {
					chessboard[row][column] = new Pawn(false);
				} else if (row == 6) {
					chessboard[row][column] = new Pawn(true);
				} else if (row == 7) {
					switch (column) {
					case 0:
						chessboard[row][column] = new Rook(true);
						break;
					case 1:
						chessboard[row][column] = new Knight(true);
						break;
					case 2:
						chessboard[row][column] = new Bishop(true);
						break;
					case 3:
						chessboard[row][column] = new Queen(true);
						break;
					case 4:
						chessboard[row][column] = new King(true);
						break;
					case 5:
						chessboard[row][column] = new Bishop(true);
						break;
					case 6:
						chessboard[row][column] = new Knight(true);
						break;
					case 7:
						chessboard[row][column] = new Rook(true);
						break;
					}
				} else {
					chessboard[row][column] = null;
				}
			}
		}
		assignWhoStartsFirst();
	}
	
	public void printBoard() {
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int row = 0; row < chessboard.length; row++) {
			System.out.print(8 - row + ".\t");
			for (int column = 0; column < chessboard[row].length; column++) {
				if (chessboard[row][column] != null) {
					chessboard[row][column].draw();
					System.out.print("\t");

				} else {
					System.out.print("\t");
				}
			}
			System.out.println();
		}
	}


	public void showScore() {
		System.out
		.println("___________________________________________________\n"
				+ "Score: White "
				+ whiteScore
				+ " | "
				+ blackScore
				+ " Black");
	}
	
	public void showWhichPlayerTurnIs() {
		if (whitesTurnToMove) {
			System.out
				.println("___________________________________________________\n"
						+ "White's turn to move\n"
						+ "Make move using this example:\n"
						+ "a2 to a3\n"
						+ "___________________________________________________\n");
		} else {
			System.out
				.println("___________________________________________________\n"
						+ "Black's turn to move\n"
						+ "Make move using this example:\n"
						+ "a7 to a6\n"
						+ "___________________________________________________\n");
		}
	}
	
	public void exitGame() {
		gameRunning = false;
		System.out.println("Thanks for playing.");
	}
	
	public void setPieceSourceAndDestination() {
		String[] components = moveCommand.toLowerCase().split(" ");
		sourceRow = 7 - (components[0].charAt(1) - '1');
		sourceColumn = components[0].charAt(0) - 'a';
		destinationRow = 7 - (components[2].charAt(1) - '1');
		destinationColumn = components[2].charAt(0) - 'a';
	}
	
	public void move() {
		if (invalidMove) {
			System.err.println("Move is invalid. Please try again:");
			invalidMove = false;
		} else {
			showWhichPlayerTurnIs();
		}
		moveCommand = user_input.nextLine();
		if (moveCommand.equalsIgnoreCase("exit")) {
			exitGame();
			return;
		}
		if (canCurrentPlayerMakeThisMove()) {
			updateScore();
			chessboard[destinationRow][destinationColumn] = chessboard[sourceRow][sourceColumn];
			chessboard[sourceRow][sourceColumn] = null;
			whitesTurnToMove = !whitesTurnToMove;
		} else {
			invalidMove = true;
			move();
		}
	}

	private boolean canCurrentPlayerMakeThisMove() {
		isMoveInBoard();
		isSourcePositionNull();
		isCurrentPlayerTurn();

		if (!chessboard[sourceRow][sourceColumn].isMoveValid(sourceRow, sourceColumn, destinationRow,
				destinationColumn)) {
			System.err.println("This piece doesn't move like that");
			return false;
		}

		if (chessboard[destinationRow][destinationColumn] == null) {
			return true;
		}

		checkIfWhiteLandsOnWhite();
		checkIfBlackLandsOnBlack();
		return true;
	}

	public boolean isMoveInBoard() throws IllegalArgumentException{
		boolean res = true;
		if (sourceRow < 0 || sourceRow > 7 || sourceColumn < 0 || sourceColumn > 7 || destinationRow < 0
				|| destinationRow > 7 || destinationColumn < 0 || destinationColumn > 7) {
			System.out.println("Move is outside the board");
			res = false;
			throw new IllegalArgumentException();
		}
		return res;
	}
	
	public boolean isSourcePositionNull() {
		if (chessboard[sourceRow][sourceColumn] == null) {
			throw new NullPointerException();
		}
		return true;
	}
	
	public boolean isCurrentPlayerTurn() {
		if ((chessboard[sourceRow][sourceColumn].isWhite() && !whitesTurnToMove)
				|| (!chessboard[sourceRow][sourceColumn].isWhite() && whitesTurnToMove)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public boolean checkIfWhiteLandsOnWhite() {
		if (chessboard[sourceRow][sourceColumn].isWhite()
				&& chessboard[destinationRow][destinationColumn].isWhite()) {
			System.err.println("White cannot land on white");
			throw new IllegalArgumentException("White cannot land on white");
		}
		return true;
	}

	public boolean checkIfBlackLandsOnBlack() {
		if (!chessboard[sourceRow][sourceColumn].isWhite()
				&& !chessboard[destinationRow][destinationColumn].isWhite()) {
			System.err.println("Black cannot land on black");
			return false;
		}
		return true;
	}

	private void updateScore() {
		if (chessboard[destinationRow][destinationColumn] == null) {
			return;
		}
		if (whitesTurnToMove) {
			whiteScore += chessboard[destinationRow][destinationColumn].relativeChessPieceValue();
		} else {
			blackScore += chessboard[destinationRow][destinationColumn].relativeChessPieceValue();

		}
	}
}
