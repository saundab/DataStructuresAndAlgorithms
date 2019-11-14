package subsetSumIntoKSubsets;

public class SubsetSumIntoKSubsets {

	public static void main(String[] args) {
		int[] nums = new int[] {4, 3, 2, 3, 5, 2, 1};
		int k = 4;
		System.out.println(new SubsetSumIntoKSubsets().met(nums, k));
	}
	
	private boolean met(int[] nums, int k) { 
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if(sum%k!=0)
			return false;
		
		return met(0, nums, new boolean[nums.length], k, 0, sum/k);
	}

	private boolean met(int startIdx, int[] arr, boolean[] used, int k, int currSum, int neededSum) {
		if (k == 1)
			return true;
		if (currSum == neededSum) {
			return met(0, arr, used, k - 1, 0, neededSum);
		}
		for (int i = startIdx; i < arr.length; i++) {
			if (used[i] == false) {
				used[i] = true;
				if (met(i + 1, arr, used, k, currSum + arr[i], neededSum)) {
					return true;
				}
				used[i] = false;
			}
		}

		return false;
	}
}
