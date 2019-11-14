package palindrome;

import java.util.HashSet;
import java.util.Set;

public class AllPalindromicDecompositions_BT {

	public static void main(String[] args) {
		new AllPalindromicDecompositions_BT().find();
	}

	private void find() {
		String str="nitin";
		Set<String> palin = new HashSet<>();
		find(str, palin);
		System.out.println(palin);
	}

	private void find(String str, Set<String> palin) {
		if(str.length()==1) {
			palin.add(str);
			return;
		}
		
		if(isPalindrome(str)) {
			palin.add(str);
		}
		
		find(str.substring(0, str.length()-1), palin);
		find(str.substring(1), palin);
	}
	
	private boolean isPalindrome(String str) {
		if(str.length()==1)
			return true;
		
		int i=0, j=str.length()-1;
		while(i<=j) {
			if(str.charAt(i)==str.charAt(j)) {
				i++;
				j--;
			}else {
				return false;
			}
		}
					
		return true;
	}
}
