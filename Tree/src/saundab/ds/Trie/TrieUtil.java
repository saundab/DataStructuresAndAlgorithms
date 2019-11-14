package saundab.ds.Trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class TrieUtil {

	private static BufferedReader buffReader = null;

	public static TrieNode getTrieFromDictionary() {
		TrieNode root = null;

		String word = null;

		while ((word = getNextWord()) != null) {
			root = makeTrie(root, word, word);
		}

		return root;
	}
	
	private static String getNextWord() {
		try {
			if (buffReader == null) {
				buffReader = new BufferedReader(new FileReader(new File("resources/words_alpha.txt")));
			}

			return buffReader.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	private static TrieNode makeTrie(TrieNode root, String ip, String word) {
		if (root == null) {
			if (ip.equals("")) {
				root = new TrieNode(word);
				return root;
			} else {
				root = new TrieNode();
			}
		} else {
			if (ip.equals("")) {
				root.word = word;
				return root;
			}
		}

		int idx = 0;
		if (ip.length() != 0) {
			idx = getAlphabeticIndexFor(ip.charAt(0));
		}
		ip = ip.substring(1, ip.length());

		root.child[idx] = makeTrie(root.child[idx], ip, word);

		return root;
	}

	private static int getAlphabeticIndexFor(int asciiIdx) {
		return asciiIdx - 97 + 1; // 97='a' 65='A'
	}

}
