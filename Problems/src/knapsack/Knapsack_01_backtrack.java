package knapsack;

/*
 * choose items within the weight so that value is maximum
 */
public class Knapsack_01_backtrack {

	public static void main(String[] args) {
		new Knapsack_01_backtrack().fillSack();
	}

	private void fillSack() {
		int[] weights={2,3,5};
		int[] values= {11,10,20};
		System.out.println(fillSack(weights, values, 5, 0, 0, 0));
	}

	private int fillSack(int[] weights, int[] values, int W, int idx, int currWeight, int currVal) {
		if(currWeight==W)
			return currVal;
		if(currWeight>W)
			return 0;
		if(idx>=weights.length)
			return 0;
		
		return Math.max(fillSack(weights, values, W, idx+1, currWeight+weights[idx], currVal+values[idx])
				, fillSack(weights, values, W, idx+1, currWeight, currVal));
	}
}
