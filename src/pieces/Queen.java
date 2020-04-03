package pieces;

import pieces.AbstractPiece;

public class Queen extends AbstractPiece {

	public Queen(boolean isWhite) {
		super(isWhite);
		
		}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("\u2655");
		}
		else{
			System.out.print("\u265B");
		}
	}

	private static Boolean diagonalPath(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn) {
		// returns true if the path is diagonal
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
	}

	private static Boolean straightPath(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn) {
		// returns true if the path is straight
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
		return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		// TODO Auto-generated method stub
		return (diagonalPath(sourceRow, sourceColumn, destinationRow, destinationColumn))
				|| straightPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		// TODO Auto-generated method stub
		return 9;
	}

}
