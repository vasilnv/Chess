package pieces;
import pieces.AbstractPiece;


public class Bishop extends AbstractPiece {
	public Bishop(boolean isWhite) {
		super(isWhite);
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
		return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return diagonalPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		return 3;
	}
}
