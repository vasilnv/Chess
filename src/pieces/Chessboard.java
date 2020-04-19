package pieces;

import java.lang.reflect.Method;
import java.util.Random;
import java.util.Scanner;

import pieces.AbstractPiece;

public class Chessboard {
	public static Boolean gameRunning;
	private AbstractPiece[][] chessboard = new AbstractPiece[NUM_OF_ROWS][NUM_OF_COLUMNS];
	private static final int NUM_OF_ROWS = 8;
	private static final int NUM_OF_COLUMNS = 8;

	public Chessboard() {
		initialiseBoard(chessboard);
		gameRunning = true;
	}
	
	private static void initialiseBoard(AbstractPiece[][] chessboard) {
		boolean isCurrentPieceWhite = false;
		for (int row = 0; row < chessboard.length; row++) {
			for (int column = 0; column < chessboard[row].length; column++) {
				if (row == 0) {
					switch (column) {
					case 0:
						chessboard[row][column] = new Rook(isCurrentPieceWhite);
						break;
					case 1:
						chessboard[row][column] = new Knight(isCurrentPieceWhite);
						break;
					case 2:
						chessboard[row][column] = new Bishop(isCurrentPieceWhite);
						break;
					case 3:
						chessboard[row][column] = new Queen(isCurrentPieceWhite);
						break;
					case 4:
						chessboard[row][column] = new King(isCurrentPieceWhite);
						break;
					case 5:
						chessboard[row][column] = new Bishop(isCurrentPieceWhite);
						break;
					case 6:
						chessboard[row][column] = new Knight(isCurrentPieceWhite);
						break;
					case 7:
						chessboard[row][column] = new Rook(isCurrentPieceWhite);
						break;
					}
				} else if (row == 1) {
					chessboard[row][column] = new Pawn(isCurrentPieceWhite);
				} else if (row == 6) {
					isCurrentPieceWhite = true;
					chessboard[row][column] = new Pawn(isCurrentPieceWhite);
				} else if (row == 7) {
					isCurrentPieceWhite = true;
					switch (column) {
					case 0:
						chessboard[row][column] = new Rook(isCurrentPieceWhite);
						break;
					case 1:
						chessboard[row][column] = new Knight(isCurrentPieceWhite);
						break;
					case 2:
						chessboard[row][column] = new Bishop(isCurrentPieceWhite);
						break;
					case 3:
						chessboard[row][column] = new Queen(isCurrentPieceWhite);
						break;
					case 4:
						chessboard[row][column] = new King(isCurrentPieceWhite);
						break;
					case 5:
						chessboard[row][column] = new Bishop(isCurrentPieceWhite);
						break;
					case 6:
						chessboard[row][column] = new Knight(isCurrentPieceWhite);
						break;
					case 7:
						chessboard[row][column] = new Rook(isCurrentPieceWhite);
						break;
					}
				} else {
					chessboard[row][column] = null;
				}
			}
		}
	}
	
	public void printBoard() {
		System.out.println("\ta\tb\tc\td\te\tf\tg\th");
		for (int row = 0; row < chessboard.length; row++) {
			System.out.print(NUM_OF_ROWS - row + ".\t");
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

	public void setPiece(int sourceRow, int sourceColumn, AbstractPiece piece) {
		this.chessboard[sourceRow][sourceColumn] = piece;
	}
	public AbstractPiece getPiece(int sourceRow, int sourceColumn) {
		return this.chessboard[sourceRow][sourceColumn];
	}
	
}


