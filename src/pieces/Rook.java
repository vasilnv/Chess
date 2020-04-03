package pieces;

import pieces.AbstractPiece;


public class Rook extends AbstractPiece {

	public Rook(boolean isWhite) {
		super(isWhite);
	}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("\u2656");
		}
		else{
			System.out.print("\u265C");
		}		
	}
	
	private static Boolean straightPath(int sourceRow, int sourceColumn,
			int destinationRow, int destinationColumn) {
		return !((sourceRow != destinationRow) && (sourceColumn != destinationColumn));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return straightPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		return 5;
	}

}
