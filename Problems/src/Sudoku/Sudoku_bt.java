package Sudoku;

public class Sudoku_bt {

	public static void main(String[] args) {
		new Sudoku_bt().solve();
	}

	private boolean solve(int[][] board, int[]arr, int row, int col) {
		if(col==9) {
			row+=1;
			col=0;
		}
		if(row==9) {
			return true;
		}
		
		if(board[row][col]==0) {
			for(int i=0;i<arr.length;i++) {
				board[row][col]=arr[i];
				if(isValidPlacement(board, row, col)) {
					if(solve(board, arr, row, col+1)) {
						return true;
					}else {
						board[row][col]=0;
					}
				}else {
					board[row][col]=0;
				}
			}
		}else {
			return solve(board, arr, row, col+1);
		}
		
		return false;
	}

	private boolean isValidPlacement(int[][] board, int row, int col) {
		//check row
		for(int r=0;r<9;r++) {
			if(r!=row && board[r][col]==board[row][col]) {
				return false;
			}
		}
		
		//check col
		for(int c=0;c<9;c++) {
			if(c!=col && board[row][c]==board[row][col]) {
				return false;
			}
		}
		
		//check cell
		int rowOffset=findOffset(row);
		int colOffset=findOffset(col);
				
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				int actualRow=i+rowOffset;
				int actualCol=j+colOffset;
				
				if(actualRow!=row && actualCol!=col 
						&& board[actualRow][actualCol]==board[row][col]) {
					return false;
				}
			}
		}
		
		return true;
	}

	private int findOffset(int idx) {
		//0-2, 3-5, 6-8
		int offset = 0;
		if(idx>=0 && idx<=2) {
			offset=0;
		}else if(idx >=3 && idx<=5) {
			offset=3;
		} else if(idx>=6 && idx<=8) {
			offset=6;
		}
		
		return offset;
	}
	
	private void solve() {
		int [][] board = {
			{0,4,0, 0,0,7, 1,0,0},
			{5,3,0, 0,9,0, 0,7,0},
			{0,0,7, 0,6,0, 9,4,0},
			{4,0,6, 0,8,0, 7,5,1},
			{0,1,0, 0,0,0, 6,9,0},
			{0,5,3, 0,1,0, 0,0,2},
			{9,6,0, 0,3,0, 0,1,0},
			{3,7,0, 0,5,1, 0,0,0},
			{1,0,0, 2,0,9, 3,6,7}};
		
		int[] arr= {1,2,3,4,5,6,7,8,9};
		
		printBoard(board);
		boolean isSolved=solve(board, arr, 0,0);
		System.out.println(isSolved);
		printBoard(board);
	}

	private void printBoard(int[][] board) {
		for(int i=0;i<board.length;i++) {
			for(int j=0;j<board[0].length;j++) {
				System.out.print(board[i][j] + "|");
			}
			System.out.println();
		}
		
	}
	
}
