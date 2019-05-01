package maxSumRectangle;

public class MaxSumRect {

	public static void main(String[] args) {
		new MaxSumRect().find();
	}

	private void find() {
		int [][] mat=new int[][] {{1,2,-1,-4,-20}, {-8,-3,4,2,1},{3,8,10,1,3},{-4,-1,1,7,-6}};
		
		int[] res = find(mat);
		for(int i:res) {
			System.out.print(i + " ");
		}
	}

	private int[] find(int[][] mat) {
		int maxSum=0;
		int p1_r=0, p1_c=0, p2_r=0, p2_c=0;
		
		//point1
		for(int p1_row=0; p1_row<mat.length; p1_row++) {
			for(int p1_col=0; p1_col<mat[0].length; p1_col++) {
				//point2
				for(int p2_row=p1_row; p2_row<mat.length; p2_row++) {
					for(int p2_col=p1_col; p2_col<mat[0].length; p2_col++) {
						
						int sum=0;
						
						for(int i=p1_row;i<=p2_row; i++) {
							for(int j=p1_col; j<=p2_col; j++) {
								sum+=mat[i][j];
							}
						}
						
						if(sum>maxSum) {
							maxSum=sum;
							p1_r=p1_row;
							p1_c=p1_col;
							p2_r=p2_row;
							p2_c=p2_col;
						}
					}
				}
				
			}
		}
		
		return new int[] {p1_r, p1_c, p2_r, p2_c, maxSum};
	}
}
