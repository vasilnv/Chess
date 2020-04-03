package pieces;

import pieces.AbstractPiece;

public class Pawn extends AbstractPiece {

	public Pawn(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (this.isWhite) {
			System.out.print("\u2659");
		}
		if (!(this.isWhite)) {
			System.out.print("\u265F");
		}
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
			if (this.isWhite) {
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
