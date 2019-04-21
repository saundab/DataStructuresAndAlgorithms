package com.dp.subsetSum.dp;


/*
 * Given a total and an array of positive integers, 
 * find out if a subset of integers from the array add to the given total
 */
public class SubsetSumUsingDP {

	public static void main(String[] args) {
		new SubsetSumUsingDP(). subsetSum();
	}

	public void subsetSum() {
		int[] arr = {1,3,4,5};
		int sum=11;
		System.out.println("isSubset :" + subsetSum(arr, sum));
	}
	
	private boolean subsetSum(int[] arr, int sum) {
		boolean[][] tmp = new boolean[arr.length+1][sum+1];
		updateFirstColToTrue(tmp);
		//print(tmp);
		
		for(int row=1; row<tmp.length; row++) {
			for(int col=1; col<tmp[0].length; col++) {
				
				//leave it
				boolean leaveIt = tmp[row-1][col];
				
				//take it
				boolean takeIt = false;
				if(col>=row)
					takeIt = tmp[row-1][col-row];
				
				tmp[row][col] = takeIt || leaveIt;
			}
		}

		print(tmp);
		return tmp[tmp.length-1][tmp[0].length-1];
	}

	private void updateFirstColToTrue(boolean[][] tmp) {
		for(int i=0; i<tmp.length; i++)
			tmp[i][0]=true;
	}

	private void print(boolean[][] tmp) {
		System.out.print("  ");
		for(int i=0; i<tmp[0].length; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		int count=0;
		for(int i=0; i<tmp.length; i++) {
			System.out.print(count++ + " ");
			for(int j=0;j<tmp[0].length; j++) {
				System.out.print((tmp[i][j]?"t":"f") + " ");
			}
			System.out.println();
		}
		
	}
	
}
