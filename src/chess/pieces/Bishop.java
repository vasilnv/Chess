package pieces;
import pieces.AbstractPiece;


public class Bishop extends AbstractPiece {
	private static final int BISHOP_VALUE = 3;
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";
	
	public Bishop(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite()) {
			System.out.print(WHITE_COLOR);
		} else {
			System.out.print(BLACK_COLOR);
		}
	}

	private static Boolean diagonalPath(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return diagonalPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		return BISHOP_VALUE;
	}
}
