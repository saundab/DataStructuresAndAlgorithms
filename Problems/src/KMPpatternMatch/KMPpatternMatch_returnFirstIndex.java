package KMPpatternMatch;

public class KMPpatternMatch_returnFirstIndex {

	public static void main(String[] args) {
		String str=new String("");
		String pattern=new String("a");
		
		/*String pattern1="AABAABAAA";
		int[] tmp = new KMPpatternMatch().findPrefixSuffix(pattern1);
		for(int i=0;i<tmp.length;i++) {
			System.out.print(tmp[i]+" ");
		}*/
		
		System.out.println(new KMPpatternMatch_returnFirstIndex().isMatch(str, pattern));
	}

	private int isMatch(String str, String pattern) {
		int[] suffix=findPrefixSuffix(pattern);
		int i=0,j=0;
		int firstMatchIdx=0;
		
		char[] word=str.toCharArray();
		char[] patt=pattern.toCharArray();
		
		while(i<word.length && j<patt.length) {
			if(word[i]==patt[j]) {
				i++;j++;
			}else {
				if(j!=0) {
					j=suffix[j-1];
					firstMatchIdx=i-j;
				}else {
					i++;
					firstMatchIdx=i;
				}
			}
		}
		
		if(j==patt.length)
			return firstMatchIdx;
		
		return -1;
	}

	//aabaabaaa
	private int[] findPrefixSuffix(String pattern) {
		if(pattern.equals(""))
			return new int[0];
		
		char[] tmp = pattern.toCharArray();
		int[] suffix=new int[tmp.length];
		suffix[0]=0;
		
		int i=0,j=1;
		while(j<pattern.length()) {
			if(tmp[i]==tmp[j]) {
				suffix[j]=i+1;
				i++;j++;
			}else {
				if(i!=0) {
					i=suffix[i-1];
				}else {
					suffix[j]=0;
					j++;
				}
			}
		}
		
		return suffix;
	}
	
}
