class WordDictionary {
    class TrieNode{
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    private TrieNode root;
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode curr = root;
        for(char ch : word.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        return searchHelper(word.toCharArray(), 0, root);
    }

    public boolean searchHelper(char[] word,int pos,TrieNode node){
      if (pos == word.length) return node.isEnd;

        char ch = word[pos];
        if (ch == '.') {
            for (TrieNode child : node.children) {
                if (child != null && searchHelper(word, pos + 1, child)) {
                    return true;
                }
            }
            return false;
        } else {
            int index = ch - 'a';
            TrieNode child = node.children[index];
            if (child == null) return false;
            return searchHelper(word, pos + 1, child);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */