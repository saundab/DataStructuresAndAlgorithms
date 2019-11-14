package editDistance;

public class LevenshteinDistance_DP {

	public static void main(String[] args) {
		String word1="dinitrophenylhydrazine";
		String word2="benzalphenylhydrazone";
		
		System.out.println(new LevenshteinDistance_DP().minDistance(word1, word2));
	}

	private int minDistance(String word1, String word2) {

		return met(word1, word2);
	}

	private int met(String str1, String str2) {
		int[][] tmp = new int[str1.length() + 1][str2.length() + 1];
		int count = 0;
		for (int row = 0; row < tmp.length; row++) {
			tmp[row][0] = count++;
		}

		count = 0;
		for (int col = 0; col < tmp[0].length; col++) {
			tmp[0][col] = count++;
		}

		for (int row = 1; row < tmp.length; row++) {
			for (int col = 1; col < tmp[0].length; col++) {
				if (str1.charAt(row - 1) == str2.charAt(col - 1)) {
					tmp[row][col] = tmp[row - 1][col - 1];
				} else {
					tmp[row][col] = 1 + Math.min(tmp[row - 1][col - 1], Math.min(tmp[row][col - 1], tmp[row - 1][col]));
				}
			}
		}

		return tmp[tmp.length - 1][tmp[0].length - 1];
	}
}
