package subsetSum;

public class SubsetSum_Tabulation {

	public static void main(String[] args) {
		new SubsetSum_Tabulation().find();
	}

	private void find() {
		int[] arr= {10,1,2,3,6};
		int totalSum=21;
		boolean[][] cache = new boolean[arr.length+1][totalSum+1];
		//update first col to true
		for(int row=0;row<cache.length;row++) {
			cache[row][0]=true;
		}
		//update first row to false from 1st index as 1st represents 0 sum
		for(int col=1;col<cache[0].length;col++) {
			cache[0][col]=false;
		}
		
		System.out.println(find(arr, 0, totalSum, cache));				
	}

	private boolean find(int[] arr, int i, int totalSum, boolean[][] cache) {
		for(int row=1;row<cache.length;row++) {
			for(int col=1;col<cache[0].length;col++) {
				
				boolean include=false;
				if(col>=arr[row-1]) {
					include=cache[row-1][col-arr[row-1]];
				}
				boolean exclude=cache[row-1][col];
				
				cache[row][col]=include||exclude;
			}
		}
		
		print(cache);
		return cache[arr.length][totalSum];
	}
	
	private void print(boolean[][] tmp) {
		System.out.print("  ");
		for(int i=0; i<tmp[0].length; i++) {
			System.out.print((i<=9?" "+i:i) + " ");
		}
		System.out.println();
		int count=0;
		for(int i=0; i<tmp.length; i++) {
			System.out.print(count++ + " ");
			for(int j=0;j<tmp[0].length; j++) {
				System.out.print((tmp[i][j]?" t":" f") + " ");
			}
			System.out.println();
		}
		
	}
}
