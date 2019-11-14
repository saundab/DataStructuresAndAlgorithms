package NQueen;

//better
public class NQ_simpler {

	public static void main(String[] args) {
		new NQ_simpler().doit();
	}

	private void doit() {
		int board[][]=new int[4][4];
		boolean success=place(board,0);
		System.out.println(success);
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board.length;col++) {
				System.out.print(board[row][col] + " ");
			}
			System.out.println();
		}
	}

	private boolean place(int[][] board, int col) {
		if(col==board.length)
			return true;
		
		boolean placed=false;
		for(int row=0;row<board.length;row++) {
			if(isSafe(board, row, col)) {
				board[row][col]=1;
				placed=true;
				if(!place(board,col+1)) {
					board[row][col]=0;
					placed=false;
				}
			}
		}
		return placed;
	}

	//IMP!!! pay attention
	private boolean isSafe(int[][] board, int row1, int col1) {
		//top
		for(int row=row1;row>=0;row--) {
			if(board[row][col1]==1)
				return false;
		}
		//top-right
		for(int row=row1,col=col1; row>=0 && col<board.length; row--,col++) {
			if(board[row][col]==1)
				return false;
		}
		//right
		for(int col=col1;col<board.length;col++) {
			if(board[row1][col]==1)
				return false;
		}
		//bottom-right
		for(int row=row1,col=col1;row<board.length&&col<board.length;row++,col++) {
			if(board[row][col]==1)
				return false;
		}
		//bottom
		for(int row=row1;row<board.length;row++) {
			if(board[row][col1]==1)
				return false;
		}
		//bottom-left
		for(int row=row1,col=col1;row<board.length&&col>=0;row++, col--) {
			if(board[row][col]==1)
				return false;
		}
		//left
		for(int col=col1;col>=0;col--) {
			if(board[row1][col]==1)
				return false;
		}
		//top-left
		for(int row=row1,col=col1;row>=0&&col>=0;row--,col--) {
			if(board[row][col]==1)
				return false;
		}
		return true;
	}
}
