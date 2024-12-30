//648. Replace words - https://leetcode.com/problems/replace-words/description/
//Time Complexity: O(N*l)
//Space Complexity: O(N*l) + O(M*l)

class Solution {
    TrieNode root;
    class TrieNode{
        TrieNode[] children;
        boolean isEnd;
        //constructor
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }

    //function to insert dictory words into Tries
    private void insert(String word){
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null){
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        StringBuilder result = new StringBuilder();
        this.root = new TrieNode();
        //insert each word of dictory into trie
        for(String word: dictionary){
            insert(word);
        }
        //split sentence into array of words
        String[] splitArr = sentence.split(" ");
        //go over each word of the senetence
        for(int i=0; i<splitArr.length; i++){
            if(i > 0){
                //append space after every split word
                result.append(" ");
            }
            result.append(getShortestVersion(splitArr[i]));
        }
        return result.toString();
    }

    private String getShortestVersion(String word){
        StringBuilder result = new StringBuilder();
        TrieNode curr = root;
        for(char c: word.toCharArray()){
            if(curr.children[c - 'a'] == null || curr.isEnd){
                break;
            }
            curr = curr.children[c - 'a'];
            result.append(c);
        }
        if(curr.isEnd){
            return result.toString();
        }
        return word;
    }
}