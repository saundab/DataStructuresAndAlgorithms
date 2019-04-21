package com.dp.subsetSum.iterative;
/*
 * Given a total and an array of positive integers, 
 * find out if a subset of integers from the array add to the given total
 */
public class SubsetSumIterative {
	
	public static void main(String[] args) {
		new SubsetSumIterative(). subsetSum();
	}

	public void subsetSum() {
		int[] arr = {1,2,3,4,5};
		int sum=5;
		System.out.println(subsetSum(arr, sum, 0)); 
		subsetSumPrintPath(arr, sum, 0, "");
	}
	
	private boolean subsetSum(int[] arr, int sum, int idx) {
		if(sum==0)
			return true;
		if(idx >= arr.length)
			return false;
		if(sum <=0)
			return false;
		
		return subsetSum(arr, sum-arr[idx], idx+1)
				|| subsetSum(arr, sum, idx+1);
	}
	
	//print path
	private void subsetSumPrintPath(int[] arr, int sum, int idx, String str) {
		if(sum==0)
			System.out.println("path :" +str);
		if(idx >= arr.length)
			return ;
		if(sum <=0)
			return ;
		
		subsetSumPrintPath(arr, sum-arr[idx], idx+1, str+"-"+arr[idx]);
		subsetSumPrintPath(arr, sum, idx+1, str);
	}
}
