package maxSumRectangleIn2dMatrix;

public class maxSumRectangleIn2dMatrix_KadanesAlgo {

	public static void main(String[] args) {
		int[][] mat = new int[][] { 
            {1, 2, -1, -4, -20}, 
            {-8, -3, 4, 2, 1}, 
            {3, 8, 10, 1, 3}, 
            {-4, -1, 1, 7, -6} 
            };
            
        System.out.println(new maxSumRectangleIn2dMatrix_KadanesAlgo().find(mat));
	}

	private prop find(int[][] mat) {
		int[] tmp = new int[mat.length];
		
		for(int L=0;L<mat[0].length;L++) {
			for(int R=L;R<mat[0].length;R++) {
				for(int row=0;row<mat.length;row++) {
					tmp[row]=tmp[row]+mat[row][R];
				}
				
				//start Kadane's algo on the tmp array
				int maxSum=tmp[0], runningSum=tmp[0];
				int start=0, end=0;
				for(int i=1;i<tmp.length;i++) {
					runningSum+=tmp[i];
					if(tmp[i]>=runningSum) {
						runningSum=tmp[i];
						start=i;end=i;
					}
					if(runningSum>maxSum) {
						maxSum=runningSum;
						end=i;
					}
				}
				//end Kadane's
				
				

			}
		}
		return null;
	}
	
	class prop{
		int maxSum;
		int startRow, startCol, endRow, endCol;
		
		@Override
		public String toString() {
			return maxSum+", "+startRow+", "+startCol+", "+endRow+", "+endCol;
		}
	}
}
