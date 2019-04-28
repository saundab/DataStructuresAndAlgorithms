package knightsTour;

import java.time.Duration;
import java.time.Instant;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

//The knight is placed on the first block of an empty board and, moving according to the rules of chess, must visit each square exactly once.
//Backtracking approach using linked hash map
public class KnightsTourMap {

	public static void main(String[] args) {
		new KnightsTourMap().tour();
	}

	private void tour() {
		int [][]board=new int[8][8];
		LinkedHashMap<Pos, Integer> visited=new LinkedHashMap<>();
		
		Pos startPos = new Pos(0,0);
		visited.put(startPos, 0);

		Instant start = Instant.now();
		
		boolean tourSuccessful = tour(board, visited, startPos, 0);
		
		Instant finish = Instant.now();
		long timeElapsed = Duration.between(start, finish).toMillis();
		System.out.println("timeElapsed(sec) :"+timeElapsed/1000);
		
		int count=0;
		if(tourSuccessful) {
			for(Entry<Pos, Integer> entry:visited.entrySet()) {
				
				System.out.print("["+entry.getKey()+"|"+entry.getValue()+"]\t");
				
				if(count%8==7)
					System.out.println();
				
				count=count+1;
			}
		}else {
			System.out.println(tourSuccessful);
		}
	}
	
	private boolean tour(int[][] board, Map<Pos, Integer>  visited, Pos pos, int count) {
		if(count==board.length*board.length -1)
			return true;

		for(int i=0; i<8; i++) {
			Pos tmpPos=getNextPos(pos, i);
			if(isValid(board, tmpPos) 
				&& !visited.containsKey(tmpPos)) {
				
				visited.put(tmpPos, count+1);
				
				boolean success=tour(board, visited, tmpPos, count+1); 
				if(success) {
					return true;
				}else {
					visited.remove(tmpPos);
				}
			}	
		}
		
		return false;
	}

	private Pos getNextPos(Pos pos, int i) {
		int row=pos.row, col=pos.col;
		
		switch(i) {
			case 0:
				row=pos.row-1;
				col=pos.col-2;
				break;
			case 1:
				row=pos.row-2;
				col=pos.col-1;
				break;
			case 2:
				row=pos.row-2;
				col=pos.col+1;
				break;
			case 3:
				row=pos.row-1;
				col=pos.col+2;
				break;
			case 4:
				row=pos.row+1;
				col=pos.col+2;
				break;
			case 5:
				row=pos.row+2;
				col=pos.col+1;
				break;
			case 6:
				row=pos.row+2;
				col=pos.col-1;
				break;
			case 7:
				row=pos.row+1;
				col=pos.col-2;
				break;
			default:
				
		}

		return new Pos(row, col);
	}

	private boolean isValid(int[][] board, Pos pos) {
		if(pos.row>=0
			&& pos.row<board.length
			&& pos.col>=0
			&& pos.col<board.length) {
			
			return true;
		}
	
		return false;
	}

	class Pos{
		int row;
		int col;
		Pos(int row, int col) {
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
			Pos other = (Pos) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (col != other.col)
				return false;
			if (row != other.row)
				return false;
			return true;
		}
		private KnightsTourMap getOuterType() {
			return KnightsTourMap.this;
		}
		@Override
		public String toString() {
			return "("+row+","+col+")";
		}
	}
}
