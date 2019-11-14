package NQueen;

import java.util.HashSet;
import java.util.Set;
//N Queen
//backtracking
public class NQueen_BT {

	public static void main(String[] args) {
		new NQueen_BT().place();
	}

	private void place() {
		int[][] board = new int[4][4];
		Set<Position> occupiedPositions= new HashSet<>();
		boolean isSuccessfullyplaced=place(board, occupiedPositions, 0);

		System.out.println("isSuccessfullyplaced : "+isSuccessfullyplaced);
		System.out.println(occupiedPositions);
	}
	
	private boolean place(int[][] board, Set<Position> occupiedPositions, int col) {
		if(col>=board.length && occupiedPositions.size()==4)
			return true;
		else if(col>=board.length)
			return false;
		
		boolean isPlaced = false;
		for(int row=0; row<board.length; row++) {
			Position tmpPos = new Position(row,col);
			
			if(isSafe(board, occupiedPositions, tmpPos)) {
				occupiedPositions.add(tmpPos);
				isPlaced=place(board, occupiedPositions, col+1);
				if(isPlaced) {
					break;
				}else {
					occupiedPositions.remove(tmpPos);
				}
			}
		}
		
		return isPlaced;
	}

	//IMP!!! pay attention
	private boolean isSafe(int[][] board, Set<Position> occupiedPositions, Position tmpPos) {
		//W
		for(int tmpCol=tmpPos.col; tmpCol>=0; tmpCol--) {
			if(occupiedPositions.contains(new Position(tmpPos.row, tmpCol))) {
				return false;
			}
		}
		
		//NW
		for(int tmpRow=tmpPos.row, tmpCol=tmpPos.col; tmpRow>=0 && tmpCol>=0; tmpRow--, tmpCol--) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpCol))) {
				return false;
			}
		}

		//N
		for(int tmpRow=tmpPos.row; tmpRow>=0; tmpRow--) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpPos.col))) {
				return false;
			}
		}
		
		//NE
		for(int tmpRow=tmpPos.row,tmpCol=tmpPos.col; tmpRow>=0 && tmpCol<=board.length; tmpRow--, tmpCol++) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpCol))) {
				return false;
			}
		}
		
		//E
		for(int tmpCol=tmpPos.col; tmpCol<=board.length; tmpCol++) {
			if(occupiedPositions.contains(new Position(tmpPos.row, tmpCol))) {
				return false;
			}
		}
		
		//SE
		for(int tmpRow=tmpPos.row, tmpCol=tmpPos.col; tmpRow<=board.length && tmpCol<=board.length; tmpRow++, tmpCol++) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpCol))) {
				return false;
			}
		}
		
		//S
		for(int tmpRow=tmpPos.row; tmpRow<=board.length; tmpRow++) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpPos.col))) {
				return false;
			}
		}
		
		//SW
		for(int tmpRow=tmpPos.row, tmpCol=tmpPos.col; tmpRow<=board.length && tmpCol>=0; tmpRow++, tmpCol--) {
			if(occupiedPositions.contains(new Position(tmpRow, tmpCol))) {
				return false;
			}
		}
		
		return true;
	}

	class Position{
		int row;
		int col;
		Position(int row, int col) {
			this.row=row;
			this.col=col;
		}
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + col;
			result = prime * result + row;
			return result;
		}
		
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Position other = (Position) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		private NQueen_BT getOuterType() {
			return NQueen_BT.this;
		}

		@Override
		public String toString() {
			return "Position [row=" + row + ", col=" + col + "]";
		}
	}
}
