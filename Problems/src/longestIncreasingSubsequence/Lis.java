package longestIncreasingSubsequence;

//Errored solution
public class Lis {

	public static void main(String[] args) {
		new Lis().findLength();
	}

	private void findLength() {
		int[] arr= {1,6,2,8,3,7,4,9,5, 10, 11};
		int maxLength=findLength(arr, 0,0,"");
		System.out.println(maxLength);
	}

	private int findLength(int[] arr, int idx, int length, String str) {
		if(idx>=arr.length) 
			return length;
		
		//This line will give WRONG result when the element is in double digits like 10, 22
		//as substring will capture only the last element
		if(str!="" && arr[idx]<Integer.parseInt(str.substring(str.length()-1))) 
			return length;
		
		return Math.max(findLength(arr, idx+1, length+1, str+arr[idx]),
				findLength(arr, idx+1, length, str));
	}
}
