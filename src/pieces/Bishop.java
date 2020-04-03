package pieces;
import pieces.AbstractPiece;


public class Bishop extends AbstractPiece {

	public Bishop(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("\u2657");
		} else {
			System.out.print("\u265D");
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

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return diagonalPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		// TODO Auto-generated method stub
		return 3;
	}

}
