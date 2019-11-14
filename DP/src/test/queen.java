package test;

public class queen {

	public static void main(String[] args) {
		new queen().place();
	}

	private void place() {
		int[][] board = new int[50][50];
		
		if(place(board, 0)) {
			for(int row=0;row<board.length; row++) {
				for(int col=0;col<board.length; col++) {
					System.out.print(board[row][col]+ " ");
				}
				System.out.println();
			}
		}else {
			System.out.println("false");
		}
	}

	private boolean place(int[][] board, int col) {
		for(int row=0; row<board.length; row++) {
			if(safe(board, row, col)) {
				board[row][col]=1;
				if(col==board.length-1 || place(board, col+1)) {
					return true;
				}else {
					board[row][col]=0;
				}
			}
		}
		
		return false;
	}

	private boolean safe(int[][] board, int row, int col) {
		//w
		for(int r=row,c=col;c>=0;c--) {
			if(board[r][c]==1)
				return false;
		}
		//nw
		for(int r=row,c=col; r>=0 && c>=0; r--, c--) {
			if(board[r][c]==1)
				return false;
		}
		//n
		for(int r=row,c=col; r>=0; r--) {
			if(board[r][c]==1)
				return false;
		}
		//ne
		for(int r=row,c=col; r>=0 && c<board.length; r--, c++) {
			if(board[r][c]==1)
				return false;
		}
		//e
		for(int r=row,c=col; c<board.length; c++) {
			if(board[r][c]==1)
				return false;
		}
		//se
		for(int r=row,c=col; r<board.length && c<board.length; r++, c++) {
			if(board[r][c]==1)
				return false;
		}
		//s
		for(int r=row,c=col; r<board.length ; r++) {
			if(board[r][c]==1)
				return false;
		}
		//sw
		for(int r=row,c=col; r<board.length && c>=0; r++, c--) {
			if(board[r][c]==1)
				return false;
		}
		
		return true;
	}
}
