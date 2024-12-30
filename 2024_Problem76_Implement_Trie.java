//208. Implement Trie(Prefix Tree) - https://leetcode.com/problems/implement-trie-prefix-tree/
//Time Complexity: O(n*l) ~ insertion
                // O(l) ~ wordSearch and prefixSearch
//Space Complexity: O(n*l) ~ insertion
                // O(1) ~ wordSearch and prefixSearch

class Trie {
    TrieNode root;
    //creating TrieNode class
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        public TrieNode(){ //constructor
            this.children = new TrieNode[26];
        }
    }

    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            //if null, create node at 'c'
            if(curr.children[c -'a'] == null){
                curr.children[c -'a'] = new TrieNode();
            }
            curr = curr.children[c -'a'];
        }
        curr.isEnd = true;// end of the word, flag=T
    }

    public boolean search(String word) {
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c -'a'] == null){
                return false; //word is not present
            }
            //iterate
            curr = curr.children[c -'a'];
        }
        return curr.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode curr = root;
        for(char c: prefix.toCharArray()){
            if(curr.children[c -'a'] == null){
                return false; //word is not present
            }
            //iterate
            curr = curr.children[c -'a'];
        }
        return true;
    }
}
