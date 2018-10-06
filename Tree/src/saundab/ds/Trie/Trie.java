package saundab.ds.Trie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Abhinav Saund 
 * 
 * Trie - Also called DIGITAL TREE, RADIX TREE or PREFIX TREE
 * 
 * It is a kind of a search tree. An ordered tree data
 * structure used to store a dynamic set or associative array where the
 * keys are usually strings.
 */
public class Trie {

	public static void main(String[] args) throws Exception {
		// Node root=new Test16().makeTrie(null, "ca", "book");
		Node root = new Trie().makeTrieFromDict();

		List<String> completeWords = new Trie().findCompleteWords(root, "zwitter");
		for (String word : completeWords) {
			System.out.println(word);
		}

		System.out.println("hell");
	}

	private List<String> findCompleteWords(Node root, String incompleteWord) throws Exception {
		List<String> completeWordsBag = new ArrayList<>();

		getAllWords(root, incompleteWord, completeWordsBag);

		return completeWordsBag;
	}

	private void getAllWords(Node root, String str, List<String> completeWordsBag) throws Exception {
		if (!str.equals("")) {
			int i = str.charAt(0) - 'a' + 1;
			if (root.child[i] != null) {
				getAllWords(root.child[i], str.substring(1, str.length()), completeWordsBag);
			} else {
				throw new Exception("Illegal word");
			}
		} else {
			if (root.word != null) {
				completeWordsBag.add(root.word);
			}
			for (int i = 1; i < root.child.length; i++) {
				if (root.child[i] != null) {
					iterateBelow(root.child[i], completeWordsBag);
				}
			}
		}

	}

	private void iterateBelow(Node node, List<String> completeWordsBag) {
		if (node.word != null) {
			completeWordsBag.add(node.word);
		}
		for (int i = 0; i < node.child.length; i++) {
			if (node.child[i] != null) {
				iterateBelow(node.child[i], completeWordsBag);
			}
		}
	}

	private Node makeTrie(Node root, String ip, String word) {
		if (root == null) {
			if (ip.equals("")) {
				root = new Node(word);
				return root;
			} else {
				root = new Node();
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

	private Node makeTrieFromDict() {
		Node root = null;
		DictReader reader = new DictReader();
		String word = null;

		while ((word = reader.getNextWord()) != null) {
			root = makeTrie(root, word, word);
		}

		return root;
	}

	private int getAlphabeticIndexFor(int asciiIdx) {
		return asciiIdx - 97 + 1; // 97='a' 65='A'
	}

	private class Node {
		String word;
		Node[] child = new Node[27];

		Node(String word) {
			this.word = word;
		}

		Node() {

		}
	}

	private class DictReader {
		private BufferedReader buffReader = null;

		private String getNextWord() {
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
	}

}
