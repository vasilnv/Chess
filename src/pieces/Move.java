package pieces;

import java.util.Random;
import java.util.Scanner;

public class Move {
	private static int sourceRow, sourceColumn, destinationRow, destinationColumn;
	private static int whiteScore = 0, blackScore = 0;
	private static Boolean whitesTurnToMove;
	private static Boolean invalidMove = false;
	private String moveCommand;
	private Scanner user_input = new Scanner(System.in);
	private Chessboard chessboard;

	public static void assignWhoStartsFirst() {
		Random rand = new Random();
		whitesTurnToMove = rand.nextBoolean();
	}

	public Move(Chessboard chessboard) {
		this.chessboard = chessboard;
		assignWhoStartsFirst();
	}

	public void makeMove() {
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
		setPieceSourceAndDestination();
		if (canCurrentPlayerMakeThisMove()) {
			updateScore();
			showScore();
			chessboard.setPiece(destinationRow, destinationColumn, chessboard.getPiece(sourceRow, sourceColumn));
			chessboard.setPiece(sourceRow, sourceColumn, null);
			whitesTurnToMove = !whitesTurnToMove;
		} else {
			invalidMove = true;
			makeMove();
		}
	}

	public void showWhichPlayerTurnIs() {
		if (whitesTurnToMove) {
			System.out.println("___________________________________________________\n" + "White's turn to move\n"
					+ "Make move using this example:\n" + "a2 to a3\n"
					+ "___________________________________________________\n");
		} else {
			System.out.println("___________________________________________________\n" + "Black's turn to move\n"
					+ "Make move using this example:\n" + "a7 to a6\n"
					+ "___________________________________________________\n");
		}
	}

	public void exitGame() {
		chessboard.setGameRunning(false);
		System.out.println("Thanks for playing.");
	}

	public void setPieceSourceAndDestination() {
		String[] components = moveCommand.toLowerCase().split(" ");
		sourceRow = 7 - (components[0].charAt(1) - '1');
		sourceColumn = components[0].charAt(0) - 'a';
		destinationRow = 7 - (components[2].charAt(1) - '1');
		destinationColumn = components[2].charAt(0) - 'a';
	}

	private boolean canCurrentPlayerMakeThisMove() {
		isMoveInBoard();
		isSourcePositionNull();
		isCurrentPlayerTurn();

		if (!chessboard.getPiece(sourceRow, sourceColumn).isMoveValid(sourceRow, sourceColumn, destinationRow,
				destinationColumn)) {
			System.err.println("This piece doesn't move like that");
			return false;
		}

		if (chessboard.getPiece(destinationRow, destinationColumn) == null) {
			return true;
		}

		checkIfWhiteLandsOnWhite();
		checkIfBlackLandsOnBlack();
		return true;
	}

	public boolean isMoveInBoard() throws IllegalArgumentException {
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
		if (chessboard.getPiece(sourceRow, sourceColumn) == null) {
			throw new NullPointerException();
		}
		return true;
	}

	public boolean isCurrentPlayerTurn() {
		if ((chessboard.getPiece(sourceRow, sourceColumn).isWhite() && !whitesTurnToMove)
				|| (!chessboard.getPiece(sourceRow, sourceColumn).isWhite() && whitesTurnToMove)) {
			throw new IllegalArgumentException();
		}
		return true;
	}

	public boolean checkIfWhiteLandsOnWhite() {
		if (chessboard.getPiece(sourceRow, sourceColumn).isWhite()
				&& chessboard.getPiece(destinationRow, destinationColumn).isWhite()) {
			System.err.println("White cannot land on white");
			throw new IllegalArgumentException("White cannot land on white");
		}
		return true;
	}

	public boolean checkIfBlackLandsOnBlack() {
		if (!chessboard.getPiece(sourceRow, sourceColumn).isWhite()
				&& !chessboard.getPiece(destinationRow, destinationColumn).isWhite()) {
			System.err.println("Black cannot land on black");
			return false;
		}
		return true;
	}

	private void updateScore() {
		if (chessboard.getPiece(destinationRow, destinationColumn) == null) {
			return;
		}
		if (whitesTurnToMove) {
			whiteScore += chessboard.getPiece(destinationRow, destinationColumn).relativeChessPieceValue();
		} else {
			blackScore += chessboard.getPiece(destinationRow, destinationColumn).relativeChessPieceValue();

		}
	}

	public void showScore() {
		System.out.println("___________________________________________________\n" + "Score: White " + whiteScore
				+ " | " + blackScore + " Black");
	}

}
