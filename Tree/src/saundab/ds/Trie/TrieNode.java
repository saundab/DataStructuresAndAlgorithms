package saundab.ds.Trie;

public class TrieNode {

	String word;
	TrieNode[] child = new TrieNode[27];

	TrieNode(String word) {
		this.word = word;
	}

	TrieNode() {

	}
}
