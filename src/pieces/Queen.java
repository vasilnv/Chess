package pieces;

import pieces.AbstractPiece;

public class Queen extends AbstractPiece {
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";
	
	public Queen(boolean isWhite) {
		super(isWhite);
		
	}

	@Override
	public void draw() {
		if (isWhite()){
			System.out.print(WHITE_COLOR);
		}
		else{
			System.out.print(BLACK_COLOR);
		}
	}

	private static Boolean diagonalPath(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn) {
		return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
	}

	private static Boolean straightPath(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destCol) {
		return (diagonalPath(sourceRow, sourceColumn, destinationRow, destCol))
				|| straightPath(sourceRow, sourceColumn, destinationRow, destCol);
	}

	@Override
	public int relativeChessPieceValue() {
		return 9;
	}

}
