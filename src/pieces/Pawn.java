package pieces;

import pieces.AbstractPiece;

public class Pawn extends AbstractPiece {

	public Pawn(boolean isWhite) {
		super(isWhite);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void draw() {
		// TODO Auto-generated method stub
		if (this.isWhite) {
			System.out.print("\u2659");
		}
		if (!(this.isWhite)) {
			System.out.print("\u265F");
		}
	}

	@Override
	public boolean isMoveValid(int sourceRow, int sourceColumn, int destinationRow, int destinationColumn) {
			
			//if pawn moves forward one
			//or moves forward two from starting position
			//or takes a piece of black colour
			//break, else return false (not valid move)
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
		// TODO Auto-generated method stub
		return 1;
	}

}
