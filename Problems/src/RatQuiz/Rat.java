package RatQuiz;

import java.util.ArrayList;
import java.util.List;

//2 moves allowed - forward and down
public class Rat {

	public static void main(String[] args) {
		new Rat().run();
	}

	private void run() {
		//0 = available, 1 = deadEnd
		int maze[][] = new int[3][3];
		maze[1][2] = 1;
		List<Pos> path = new ArrayList<>();
		path.add(new Pos(0,0));
		
		boolean success = run(maze, new Pos(0,0), new Pos(2,2), path );
		if(success) {
			System.out.println("Path found");
			System.out.println(path);
		}else
			System.out.println("No path found");
	}

	private boolean run(int[][] maze, Pos start, Pos end, List<Pos> path) {
		if(start.equals(end))
			return true;
		
		if(start.row>=maze.length || start.col>=maze.length)
			return false;
		if(maze[start.row][start.col] == 1)
			return false;
		
		int row = start.row;
		int col = start.col;
		
		//right
		col+=1;
		Pos p = new Pos(row, col);
		path.add(p);
		boolean success = run(maze, p, end, path);
		
		//down
		if(!success) {
			path.remove(p);
			col-=1;
			row+=1;
			p = new Pos(row, col);
			path.add(p);
			success = run(maze, new Pos(row, col), end, path);
		}
		
		return success;
	}
	
	class Pos{
		int row;
		int col;
		Pos(int row, int col){
			this.row=row;
			this.col=col;
		}
		public int getRow() {
			return row;
		}
		public void setRow(int row) {
			this.row = row;
		}
		public int getCol() {
			return col;
		}
		public void setCol(int col) {
			this.col = col;
		}
		@Override
		public String toString() {
			return "Pos [row=" + row + ", col=" + col + "]";
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
		private Rat getOuterType() {
			return Rat.this;
		}
	}
	
}
