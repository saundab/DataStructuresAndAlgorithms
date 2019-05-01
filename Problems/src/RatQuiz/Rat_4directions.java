package RatQuiz;

public class Rat_4directions {

	public static void main(String[] args) {
		new Rat_4directions().run();
	}

	private void run() {
		int[][] maze = getMaze();
		
		printMatrix(maze);
		
		int[] start= {0,0};
		int[] end= {4,6};
		
		int[][]visited=new int[maze.length][maze[0].length];
		boolean isSuccess= run(maze,start,end, visited);
		
		if(isSuccess) {
			System.out.println("Successful");
			printMatrix(visited);
		}else {
			System.out.println("No luck!");
		}
		
	}

	private boolean run(int[][] maze, int[] start, int[] end, int[][] visited) {
		//out of bounds
		if(start[0]<0 || start[0]>=maze.length || start[1]<0 || start[1]>=maze.length)
			return false;
		
		//hit wall
		if(maze[start[0]][start[1]]==1)
			return false;
		
		if(visited[start[0]][start[1]]==1)
			return false;
		
		//finish
		if(start[0]==end[0] && start[1]==end[1])
			return true;
		
		visited[start[0]][start[1]]=1;
		
		//right
		int[] nextDir={start[0], start[1]+1};
		if(run(maze, nextDir, end, visited)) {
			return true;
		}
		
		//down
		nextDir=new int[]{start[0]+1, start[1]};
		if(run(maze, nextDir, end, visited))
			return true;
		
		//left
		nextDir=new int[]{start[0], start[1]-1};
		if(run(maze, nextDir, end, visited))
			return true;
		
		//up
		nextDir=new int[]{start[0]-1, start[1]};
		if(run(maze, nextDir, end, visited))
			return true;
		
		visited[start[0]][start[1]]=0;
		return false;
	}

	private void printMatrix(int[][] maze) {
		for(int i=0;i<maze.length;i++) {
			for(int j=0;j<maze[0].length;j++) {
				System.out.print((maze[i][j]==1?"O":".")+" ");
			}
			System.out.println();
		}
	}

	private int[][] getMaze() {
		int [][] maze =new int[9][11];
		int [][] blocks= new int[][] {
		{1,3},{1,4},{1,5},{1,6},{1,7},{1,8},{1,9},
		{2,1},{2,3},{2,9},
		{3,1},{3,3},{3,5},{3,6},{3,7},{3,9},
		{4,1},{4,3},{4,7},{4,9},
		{5,1},{5,3},{5,4},{5,5},{5,6},{5,7},{5,9},
		{6,1},{6,9},
		{7,1},{7,2},{7,3},{7,4},{7,5},{7,6},{7,7},{7,8},{7,9}};

		for(int i=0;i<blocks.length;i++) {
			maze[blocks[i][0]][blocks[i][1]]=1;
		}
		return maze;
	}
	
	class Point{
		int row, col;
		Point(int row, int col){
			this.row=row;
			this.col=col;
		}
	}
}
