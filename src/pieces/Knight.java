package pieces;


public class Knight extends pieces.AbstractPiece {
	private static final String WHITE_COLOR = "\u2654";
	private static final String BLACK_COLOR = "\u265A";
	
	public Knight(boolean isWhite) {
		super(isWhite);
			}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print(WHITE_COLOR);
		}
		else{
			System.out.print(BLACK_COLOR);
		}		
	}
	
	private static Boolean lShapedPath(int sourceRow, int sourceColumn,
			int destinationRow, int destinationColumn) {
		return ((Math.abs(sourceRow - destinationRow) == 2 && Math.abs(sourceColumn
				- destinationColumn) == 1)
				|| (Math.abs(sourceRow - destinationRow) == 1 && Math.abs(sourceColumn
						- destinationColumn) == 2));
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
		return lShapedPath(sourceRow, sourceColumn, destinationRow, destinationColumn);
	}

	@Override
	public int relativeChessPieceValue() {
		return 3;
	}

}
