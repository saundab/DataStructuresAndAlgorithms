package test;

public class SubsetSum {

	public static void main(String[] args) {
		new SubsetSum().find();
	}

	private void find() {
		int[] arr= {10,1,2,3,5,9};
		find(arr, 0, 21, "");
	}

	private void find(int[] arr, int idx, int currSum, String str) {
		if(currSum==0) {
			System.out.println(str);
			return ;
		}
		if(idx>=arr.length)
			return ;
		if(currSum<0)
			return ;
		
		find(arr, idx+1, currSum-arr[idx], str+" "+arr[idx]);
		find(arr, idx+1, currSum, str);
	}
}
