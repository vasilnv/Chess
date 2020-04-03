package pieces;


public class Knight extends pieces.AbstractPiece {

	public Knight(boolean isWhite) {
		super(isWhite);
			}

	@Override
	public void draw() {
		if (isWhite){
			System.out.print("\u2658");
		}
		else{
			System.out.print("\u265E");
		}		
	}
	
	private static Boolean lShapedPath(int sourceRow, int sourceColumn,
			int destinationRow, int destinationColumn) {
		// returns true if the path is L-shaped
		// arguments are initial and final coordinates of move in chessboard
		// array
		// good for checking if a move is valid
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
