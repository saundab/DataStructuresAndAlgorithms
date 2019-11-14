package longestIncreasingSubsequence;

public class Lis_tabulation_printSeq {

	public static void main(String[] args) {
		new Lis_tabulation_printSeq().find();
	}

	private void find() {
		int[] arr= {11, 4, 12, 3, 13, 2, 14, 1, 15, 16, 17, 19};
		Key[] tmp=new Key[arr.length];
		
		tmp[0]=new Key();
		tmp[0].length=1;
		tmp[0].seq=""+arr[0];
		
		find(arr, tmp);
		for(int i=0; i<tmp.length; i++) {
			System.out.println(i + " - " + tmp[i].length + " - " + tmp[i].seq);
		}
	}

	private int find(int[] arr, Key[] tmp) {
		int maxLength=0;
		
		for(int i=1; i<arr.length; i++) {
			tmp[i]=new Key();
			tmp[i].length=1;
			tmp[i].seq=""+arr[i];
			
			for(int j=0;j<i;j++) {
				if(arr[i]>=arr[j]) {
					if(1+tmp[j].length > tmp[i].length) {
						tmp[i].length= 1+tmp[j].length;
						tmp[i].seq= tmp[j].seq+" "+arr[i];
					}
				}
			}
			
			maxLength=Math.max(maxLength,  tmp[i].length);
		}
		
		return maxLength;
	}

	class Key{
		int length;
		String seq;
	}
}
