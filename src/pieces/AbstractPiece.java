package pieces;

public abstract class AbstractPiece {

	private boolean isWhite;

	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	public boolean isWhite() {
		return isWhite;
	}

	public abstract void draw();

	public abstract boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn);

	public abstract int relativeChessPieceValue();

}
