package longestCommonSubstring;

//Top down recursive approach (Memoization)
//as opposed to bottom up iterative one (Tabulation)
//although this is not a dp as we are not storing repetetive computaiton results
public class LCS {

	public static void main(String[] args) {
		new LCS().find();
	}

	private void find() {
		String str1 = "A";
		String str2 = "XBXC";
		int length = find(str1, str2);
		System.out.println(length);
	}

	private int find(String str1, String str2) {
		if(str1.length()==0 || str2.length()==0)
			return 0;
		
		if(str1.charAt(str1.length()-1) == str2.charAt(str2.length()-1)) {
			return 1+find(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1));
		}else {
			return Math.max(find(str1, str2.substring(0, str2.length()-1)),
					find(str1.substring(0, str1.length()-1), str2));
		}
	}
	
}