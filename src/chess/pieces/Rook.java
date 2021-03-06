package chess.pieces;

import chess.pieces.AbstractPiece;

public class Rook extends AbstractPiece {
	private static final int ROOK_VALUE = 5;
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";

	public Rook(boolean isWhite) {
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

	private static Boolean straightPath(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return straightPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		return ROOK_VALUE;
	}

}
