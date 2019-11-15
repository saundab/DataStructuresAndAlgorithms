package KMPpatternMatch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class KMPpatternMatch_withInputMapping {

	public static String stringToString(String input) {
        return "";// JsonArray.readFrom("[" + input + "]").get(0).asString();
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line;
        while ((line = in.readLine()) != null) {
            String haystack = line;
            line = in.readLine();
            String needle = line;
            
            int ret = new Solution().strStr(haystack, needle);
            
            String out = String.valueOf(ret);
            
            System.out.print(out);
        }
    }
}

class Solution {
    public int strStr(String haystack, String needle) {
        return isMatch(haystack, needle);
    }
         
    private int isMatch(String str, String pattern) {
        System.out.print(str);
        System.out.print(pattern);
        
        if(str.equals("") || pattern.equals(""))
			return 0;
        
		int[] suffix=findPrefixSuffix(pattern);
		int i=0,j=0;
		
		char[] word=str.toCharArray();
		char[] patt=pattern.toCharArray();
		int firstMatchIdx=0;
        
		while(i<word.length && j<patt.length) {
			if(word[i]==patt[j]) {
				i++;j++;
			}else {
				if(j!=0){
					j=suffix[j-1];
                     firstMatchIdx=i-j;
                }else {
					i++;
					firstMatchIdx=i;
				}
			}
		}
		
		if(j==patt.length)
			return  firstMatchIdx;
		
		return  -1;
	}

	//aabaabaaa
	private int[] findPrefixSuffix(String pattern) {
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
