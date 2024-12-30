//720. Longest word in Dictionary - https://leetcode.com/problems/longest-word-in-dictionary/description/
//Time Complexity: O(n*l)
//Space Complexity: O(n*l)

class Solution {
    TrieNode root;

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() { // constructor
            this.children = new TrieNode[26];
        }
    }

    private void insert(String word) {
        TrieNode curr = root;
        for (char c : word.toCharArray()) {
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isWord = true;
    }

    String result;
    public String longestWord(String[] words) {
        this.root = new TrieNode();
        for(String word: words){
            insert(word);
        }
        this.result = "";
        //once all the words are inserted, do dfs to search the longest word
        dfs(root, new StringBuilder());
        return result;
    }

    private void dfs(TrieNode curr, StringBuilder path){
        //base case
        if(result.length() < path.length()){
            result = path.toString();
        }

        //logic
        for(int i=0; i<26; i++){
            if(curr.children[i] != null && curr.children[i].isWord){ //isWord=True
                int length = path.length();
                //action
                path.append((char)(i+'a'));
                //recurse
                dfs(curr.children[i], path);
                //backtrack
                path.setLength(length);
            }
        }
    }
}
