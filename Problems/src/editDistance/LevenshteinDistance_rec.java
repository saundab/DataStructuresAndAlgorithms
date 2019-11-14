package editDistance;

public class LevenshteinDistance_rec {

	public static void main(String[] args) {
		String word1="dinitrophenylhydrazine";
		String word2="benzalphenylhydrazone";
		
		System.out.println(new LevenshteinDistance_rec().minDistance(word1, word2));
	}

	public int minDistance(String word1, String word2) {

		return met(word1, word2, word1.length() - 1, word2.length() - 1);
	}

	private int met(String str1, String str2, int i, int j) {
		// case1
		if (i < 0 || j < 0) {
			return Math.max(i, j) + 1;
		}

		if (str1.charAt(i) == str2.charAt(j)) {
			return met(str1, str2, i - 1, j - 1);
		} else {
			// case3
			return 1 + Math.min(met(str1, str2, i - 1, j - 1),
					Math.min(met(str1, str2, i, j - 1), met(str1, str2, i - 1, j)));
		}
	}
}
