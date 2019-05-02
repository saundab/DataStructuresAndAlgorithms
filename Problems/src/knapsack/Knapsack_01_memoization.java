package knapsack;

import java.util.HashMap;
import java.util.Map;

public class Knapsack_01_memoization {

	public static void main(String[] args) {
		new Knapsack_01_memoization().fillSack();
	}

	private void fillSack() {
		int[] weights= {2,3,5};
		int[] values = {5,10,20};
		Map<Key, Integer> map = new HashMap<>();
		System.out.println(fillSack(weights, values, 5, 0, 0, 0, map));
	}
	
	private int fillSack(int[] weights, int[] values, int W, int idx, int currWeight, int currVal, Map<Key, Integer> map) {
		if(currWeight==W)
			return currVal;
		if(currWeight>W)
			return 0;
		if(idx>=weights.length)
			return 0;
		
		System.out.println(currWeight + " " + currVal);
		Key key = new Key(currWeight, currVal);
		if(map.get(key)==null) {
			int include = fillSack(weights, values, W, idx+1, currWeight+weights[idx], currVal+values[idx], map);
			map.put(new Key(currWeight+weights[idx], currVal+values[idx]), include);
			
			int exclude = fillSack(weights, values, W, idx+1, currWeight, currVal, map);
			map.put(key, Math.max(include, exclude));
		}else {
			System.out.println("found it");
		}
		
		return map.get(key);
	}
	
	class Key{
		int currVal;
		int currWeight;
		public Key(int currVal, int currWeight) {
			super();
			this.currVal = currVal;
			this.currWeight = currWeight;
		}
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + currVal;
			result = prime * result + currWeight;
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
			Key other = (Key) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (currVal != other.currVal)
				return false;
			if (currWeight != other.currWeight)
				return false;
			return true;
		}
		private Knapsack_01_memoization getOuterType() {
			return Knapsack_01_memoization.this;
		}
		@Override
		public String toString() {
			return "currVal=" + currVal + ", currWeight=" + currWeight;
		}
	}
}
