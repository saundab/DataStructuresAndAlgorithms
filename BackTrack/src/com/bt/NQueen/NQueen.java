package com.bt.NQueen;

import java.util.HashSet;
import java.util.Set;

public class NQueen {

	public static void main(String[] args) {
		new NQueen().place();
	}

	private void place() {
		int[][] board = new int[4][4];
		Set<Position> occupiedPositions = new HashSet<>();
		System.out.println(place(board, occupiedPositions, 0));
	}
	
	private boolean place(int[][] board, Set<Position> occupiedPositions, int col) {
		if(col>=board.length)
			return false;
		boolean placed = false;
		for(int row=0;row<board.length;row++) {
			Position p = new Position(row, col);
			if(safe(occupiedPositions, p)) {
				occupiedPositions.add(p);
				if(placed=place(board, occupiedPositions, col+1) == true) {
					break;
				}
			}
				
		}
		
		if(!placed)
			return false;
		
		return true;
	}

	private boolean safe(Set<Position> occupiedPositions, Position p) {
		boolean safe =  true;
		//top left
		//top right
		//bottom left
		//bottom right
		
		//vertical
		//horizontal
		
		
		return safe;
	}

	private class Position{
		int row, col;
		Position(int row, int col){
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
		private NQueen getOuterType() {
			return NQueen.this;
		}
	}
}
