package palindrome;

import java.util.ArrayList;
import java.util.List;

public class AllPalindromicDecompositions {

	public static void main(String[] args) {
		new AllPalindromicDecompositions().find();
	}

	private void find() {
		String str="aab";
		List<String> palindromes = new ArrayList<>();
		find(str, 0, palindromes);
	}

	private void find(String str, int startIdx, List<String> palindromes) {
		
		for(int i=0;i<str.length();i++) {
			String sub =str.substring(startIdx, i+1);
			
			if(isPalindrome(sub)) {
				palindromes.add(sub);
				find(str, startIdx+1, palindromes);
				palindromes.remove(sub);
			}
		}
	}

	private boolean isPalindrome(String substring) {
		// TODO Auto-generated method stub
		return false;
	}
	
	
}
