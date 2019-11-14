package longestIncreasingSubsequence;

public class Lis_BT {

	public static void main(String[] args) {
		new Lis_BT().find();
	}

	private void find() {
		int[] arr= {11, 4, 12, 3, 13, 2, 14, 1, 15};
		int subSeqLength = find(arr, 0, 0, "", "");
		System.out.println(subSeqLength);
	}

	private int find(int[] arr, int idx, int count, String subSeq, String lastEle) {
		if(idx>=arr.length) {
			System.out.println(subSeq);
			return count;
		}
		
		int takeCount=count, leaveCount=count;
		
		//take but conditionally
		if(lastEle=="" || (lastEle!=""
				&& (arr[idx] >= Integer.parseInt(lastEle)))) {
		
				takeCount=find(arr, idx+1, count+1, subSeq+"-"+arr[idx], ""+arr[idx]);
		}
		
		//leave
		leaveCount=find(arr, idx+1, count, subSeq, lastEle);
		
		return Math.max(takeCount, leaveCount);
	}
}
