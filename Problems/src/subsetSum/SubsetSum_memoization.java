package subsetSum;

import java.util.HashMap;
import java.util.Map;

public class SubsetSum_memoization {

	public static void main(String[] args) {
		new SubsetSum_memoization().find();
	}

	private void find() {
		int[] arr= {10,1,2,3,5,9};
		int totalSum=21;
		Boolean[][] cache = new Boolean[arr.length][totalSum+1];
		Map<key, Boolean> map = new HashMap<>();
		find(arr, 0, totalSum, "", map, cache);		
	}

	private boolean find(int[] arr, int idx, int currSum, String str, Map<key, Boolean> map, Boolean[][] cache) {
		if(currSum==0) {
			System.out.println(str);
			return true;
		}
		if(currSum<0)
			return false;
		if(idx>=arr.length)
			return false;

		boolean include=find(arr, idx+1, currSum-arr[idx], str+" "+arr[idx], map, cache);
		boolean exclude=find(arr, idx+1, currSum, str, map, cache);
		
		if(cache[idx][currSum]==null) {
			boolean res = include||exclude;
			cache[idx][currSum]=res;
		}
		
	/*	if(map.get(new key(idx, currSum))==null) {
			boolean res = include||exclude;
			
			map.put(new key(idx, currSum), res);
		}*/
		
		//return map.get(new key(idx, currSum));
		return cache[idx][currSum];
	}
	
	class key{
		int idx;
		int currSum;
		key(int idx, int currSum){
			this.idx = idx;
			this.currSum=currSum;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + currSum;
			result = prime * result + idx;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			key other = (key) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (currSum != other.currSum)
				return false;
			if (idx != other.idx)
				return false;
			return true;
		}
		private SubsetSum_memoization getOuterType() {
			return SubsetSum_memoization.this;
		}
	}
}
