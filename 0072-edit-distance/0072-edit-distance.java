class Solution {
    private int solve(String word1, String word2,int i,int j,int[][] memo){
        if(i == word1.length()){
            return word2.length() - j;
        }
        if(j == word2.length()){
            return word1.length() - i;
        }
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        if(word1.charAt(i) == word2.charAt(j)){
            return memo[i][j] =  solve(word1, word2, i + 1, j + 1,memo);
        } else {
            int insert = 1 + solve(word1, word2, i, j + 1,memo);
            int delete = 1 + solve(word1, word2, i + 1, j,memo);
            int update = 1 + solve(word1, word2, i + 1, j + 1,memo);
            return memo[i][j] =   Math.min(insert, Math.min(delete, update));
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] memo = new int[501][501];
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        return solve(word1,word2,0,0,memo);
    }
}