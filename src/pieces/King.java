package pieces;

import pieces.AbstractPiece;

public class King extends AbstractPiece {
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";

	public King(boolean isWhite) {
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

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return Math.abs(destinationRow - sourceRow) <= 1 || Math.abs(destinationColumn - sourceColumn) <= 1;
	}

	@Override
	public int relativeChessPieceValue() {
		return 0;
	}

}
