package pieces;
import pieces.AbstractPiece;


public class King extends AbstractPiece {

	public King(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite) {
			System.out.print("\u2654");
		} else {
			System.out.print("\u265A");
		}
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return Math.abs(destinationRow - sourceRow) <= 1
				|| Math.abs(destinationColumn - sourceColumn) <= 1;
	}

	@Override
	public int relativeChessPieceValue() {
		return 0;
	}

}
