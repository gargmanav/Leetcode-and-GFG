class TrieNode{
    TrieNode[] children;
    boolean isEnd;
    String word;
    TrieNode(){
      children = new TrieNode[26];
      isEnd = false;
      word = "";
    }
}
class Solution {
    private TrieNode root = new TrieNode();
    int m,n;
    List<String> result = new ArrayList<>();
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private boolean search(String str){
      TrieNode curr = root;
      for(char ch : str.toCharArray()){
        int index = ch - 'a';
        if(curr.children[index] == null)return false;
        curr = curr.children[index];
      }
      return curr.isEnd;
    }
    private void insert(String str){
        TrieNode curr = root;
        for(char ch : str.toCharArray()){
            int index = ch - 'a';
            if(curr.children[index] == null){
                curr.children[index] = new TrieNode();
            }
            curr = curr.children[index];
        }
        curr.isEnd = true;
        curr.word = str;
    }
    private void checkword(int i,int j,char[][] board,TrieNode curr){
       if (i < 0 || i >= m || j < 0 || j >= n || board[i][j] == '$') return;

    char ch = board[i][j];
    int index = ch - 'a';

    if (curr.children[index] == null) return;

    curr = curr.children[index]; // ✅ move to next node

    if (curr.isEnd) {
        result.add(curr.word);
        curr.isEnd = false; // avoid duplicate
    }

    board[i][j] = '$';

    for (int[] dir : directions) {
        int ni = i + dir[0];
        int nj = j + dir[1];
        checkword(ni, nj, board, curr);
    }

    board[i][j] = ch; // backtrack
    }

    public List<String> findWords(char[][] board, String[] words) {
        m = board.length;
        n = board[0].length;
        for(String word : words){
           insert(word);
        }
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                char ch = board[i][j];
                if(root.children[ch - 'a'] != null){
                    checkword(i,j,board,root);
                }
            }
        }
        return result;
    }
}