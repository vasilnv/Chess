package pieces;

public abstract class AbstractPiece {

	protected boolean isWhite;

	/**
	 * If piece is white set true, false otherwise
	 */
	public AbstractPiece(boolean isWhite) {
		this.isWhite = isWhite;
	}

	/**
	 * Returns true if white, false otherwise
	 */
	public boolean isWhite() {
		// TODO Auto-generated method stub
		return isWhite;
	}

	/**
	 * Draws given piece into the console
	 */
	public abstract void draw();

	/**
	 * Checks whether a given move is valid. Returns true if valid, false
	 * otherwise
	 */
	public abstract boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn);

	/**
	 * Returns relative chess piece value of this chessman.
	 * @return
	 */
	public abstract int relativeChessPieceValue();

}
