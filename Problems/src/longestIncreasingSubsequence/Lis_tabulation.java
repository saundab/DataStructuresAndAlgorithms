package longestIncreasingSubsequence;

public class Lis_tabulation {

	public static void main(String[] args) {
		new Lis_tabulation().find();
	}

	private void find() {
		int[] arr= {11, 4, 12, 3, 13, 2, 14, 1, 15, 16, 17, 19};
		int[] tmp=new int[arr.length];
		tmp[0]=1;
		
		int subSeqLength = find(arr, tmp);
		System.out.println(subSeqLength);
	}

	private int find(int[] arr, int[] tmp) {
		int maxLength=0;
		
		for(int i=1; i<arr.length; i++) {
			for(int j=0;j<i;j++) {
				if(arr[i]>=arr[j]) {
					tmp[i]=Math.max(tmp[i],  1+tmp[j]);
				}
			}
			
			maxLength=Math.max(maxLength,  tmp[i]);
		}
		
		return maxLength;
	}

}
