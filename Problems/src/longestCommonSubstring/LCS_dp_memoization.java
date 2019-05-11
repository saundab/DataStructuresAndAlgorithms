package longestCommonSubstring;

import java.util.HashMap;
import java.util.Map;

//reference: https://www.techiedelight.com/longest-common-subsequence/

public class LCS_dp_memoization {
	
	public static void main(String[] args) {
		new LCS_dp_memoization().findLength();
	}

	private void findLength() {
		String str1="ABC";
		String str2="AxBxCx";
		Map<String, Integer> map=new HashMap<>();
		System.out.println(findLength(str1, str2, map));
	}

	private int findLength(String str1, String str2, Map<String, Integer> map) {
		if(str1.equalsIgnoreCase("") || str2.equalsIgnoreCase(""))
			return 0;
		
		String key=str1+"|"+str2;
		
		if(map.get(key)==null) {
			System.out.println("Didn't find it in map");
			if(str1.charAt(str1.length()-1)==str2.charAt(str2.length()-1)) {
				map.put(key,  
						1+findLength(str1.substring(0, str1.length()-1), str2.substring(0, str2.length()-1), map));
			}else {
				map.put(key,
				Math.max(findLength(str1, str2.substring(0,str2.length()-1), map),
						findLength(str1.substring(0, str1.length()-1), str2, map))
				);
			}
		}else {
			System.out.println("Found it in map");
		}
		
		return map.get(key);
	}
}
