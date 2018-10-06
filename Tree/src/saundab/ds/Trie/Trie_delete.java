package saundab.ds.Trie;

import java.util.List;

public class Trie_delete {

	public static void main(String[] args) throws Exception {
		Trie trie = new Trie();
		TrieNode root=trie.makeTrieFromDict();
		
		List<String> completeWords = trie.findCompleteWords(root, "zwitter");
		
		for (String word : completeWords) {
			System.out.println(word);
		}
		
		trie.deleteWord(root, "zwitter");
		
		completeWords = trie.findCompleteWords(root, "zwitter");
		for (String word : completeWords) {
			System.out.println(word);
		}
	}
	

}
