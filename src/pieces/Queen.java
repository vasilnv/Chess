package pieces;

import pieces.AbstractPiece;

public class Queen extends AbstractPiece {

	public Queen(boolean isWhite) {
		super(isWhite);
		
		}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("\u2655");
		}
		else{
			System.out.print("\u265B");
		}
	}

	private static Boolean diagonalPath(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn) {
		return ((Math.abs(sourceRow - destinationRow) == Math.abs(sourceColumn - destinationColumn)));
	}

	private static Boolean straightPath(int sourceRow, int sourceColumn, int destinationRow,
			int destinationColumn) {
		return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destCol) {
		return (diagonalPath(sourceRow, sourceColumn, destinationRow, destCol))
				|| straightPath(sourceRow, sourceColumn, destinationRow, destCol);
	}

	@Override
	public int relativeChessPieceValue() {
		// TODO Auto-generated method stub
		return 9;
	}

}
