package StringInterleaving;

public class StringInterleaving_bruteForce {

	private boolean isInterleaved_Iterative(String a,String b,String c) {
		int i=0, j=0, k=0;
		while(k<c.length() && (i<a.length() || j<b.length())) {
			if(i<a.length() && c.charAt(k)==a.charAt(i)) {
				i++;
				k++;
			}else if(j<b.length() && c.charAt(k)==b.charAt(j)) {
				j++;
				k++;
			}
		}
		
		if(k==c.length() && i==a.length() && j==b.length())
			return true;
		
		return false;
	}	
	
	private boolean isInterleaved_Recursive(String a,String b,String c, int i, int j, int k) {
		if(k==c.length() && (i==a.length() && j==b.length())) {
			return true;
		}
		if(k==c.length() && (i<a.length() || j<b.length())){
			return false;
		}
		if(k<c.length() && (i==a.length() && j==b.length())){
			return false;
		}
		
		return ((i<a.length() && a.charAt(i)==c.charAt(k) && isInterleaved_Recursive(a,b,c,i+1,j,k+1))
				|| (j<b.length() && b.charAt(j)==c.charAt(k) && isInterleaved_Recursive(a,b,c,i,j+1,k+1)));
	}

	public static void main(String[] args) {
		String A="ABC";
		String B="DEF";
		
		String C="ABCDEF";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
		C="ADBECF";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
		C="DEFABC";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
		C="";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
		C="ABCDE";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
		C="ABDDEFG";
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Iterative(A,B,C));
		System.out.println(new StringInterleaving_bruteForce().isInterleaved_Recursive(A,B,C, 0,0,0));
		
	}

}
