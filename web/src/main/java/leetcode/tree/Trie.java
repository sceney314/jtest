package leetcode.tree;

/**
 * 2020-05-29 16:48
 */
public class Trie {
    private class TrieNode{
        public char val;
        public boolean isWord;
        public TrieNode[] sons = new TrieNode[26];
        public TrieNode(){}
        public TrieNode(char val){
            this.val = val;
        }
    }

    public TrieNode root;

    /** Initialize your data structure here. */
    public Trie() {
        TrieNode node = new TrieNode(' ');
        root = node;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode tree = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(tree.sons[idx] == null){
                tree.sons[idx] = new TrieNode(c);
            }
            tree = tree.sons[idx];
        }
        tree.isWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode tree = root;
        for(int i = 0; i < word.length(); i++){
            char c = word.charAt(i);
            int idx = c - 'a';
            if(tree.sons[idx] == null){
                return false;
            }
            tree = tree.sons[idx];
        }

        return tree.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode tree = root;
        for(int i = 0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            int idx = c - 'a';
            if(tree.sons[idx] == null){
                return false;
            }
            tree = tree.sons[idx];
        }
        return true;
    }
}
