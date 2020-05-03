package pieces;

import pieces.AbstractPiece;

public class Pawn extends AbstractPiece {
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";
	
	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite()) {
			System.out.print(WHITE_COLOR);
		}
		if (!(this.isWhite())) {
			System.out.print(BLACK_COLOR);
		}
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		if (this.isWhite()) {
			return (((sourceColumn == destinationColumn) && sourceRow == (destinationRow + 1))
					|| ((sourceRow == 6) && (sourceColumn == destinationColumn) && (sourceRow == (destinationRow + 2)))
					|| ((sourceRow == (destinationRow + 1))
							&& (Math.abs(sourceColumn - destinationColumn) == 1)));
		}
		else {
			return (((sourceColumn == destinationColumn) && sourceRow == (destinationRow - 1))
					|| ((sourceRow == 1) && (sourceColumn == destinationColumn) && (sourceRow == (destinationRow - 2)))
					|| ((sourceRow == (destinationRow - 1))
						&& (Math.abs(sourceColumn - destinationColumn) == 1)));
		}	
	}

	@Override
	public int relativeChessPieceValue() {
		return 1;
	}

}
