package longestCommonSubstring;
import java.util.ArrayList;
import java.util.List;

//bottom up approach using Tabulation
public class LCS_dp {

	public static void main(String[] args) {
		new LCS_dp().find();
	}

	private void find() {
		String str1="ABC";
		String str2="AXBXC";
		int[][] tmp = new int[str1.length()+1][str2.length()+1];
		
		List<Character> lcs = new ArrayList<>();
		int length = find(tmp, str1, str2, lcs);
		System.out.println(length);
		System.out.println(lcs);
	}

	private int find(int[][] tmp, String str1, String str2, List<Character> lcs) {
		for(int row=1; row<tmp.length; row++) {
			for(int col=1; col<tmp[0].length; col++) {
				if(str1.charAt(row-1) == str2.charAt(col-1)) {
					tmp[row][col]=1+tmp[row-1][col-1];
					lcs.add(str1.charAt(row-1) );
				}else{
					tmp[row][col]=Math.max(tmp[row][col-1], tmp[row-1][col]);
				}
			}
		}
		return tmp[tmp.length-1][tmp[0].length-1];
	}
	
}