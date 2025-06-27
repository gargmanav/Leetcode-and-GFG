class Solution {

    int[][] dp;
    int[][] moves = {
        {4,6},    // 0
        {6,8},    // 1
        {7,9},    // 2
        {4,8},    // 3
        {0,3,9},  // 4
        {},       // 5 -> no move
        {0,1,7},  // 6
        {2,6},    // 7
        {1,3},    // 8
        {2,4}     // 9
    };
    public int knightDialer(int n) {
        dp = new int[n+1][10];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        int count = 0;
        for(int i = 0;i < moves.length;i++){
            count = (count + dfs(n - 1,i)) % 1000000007;
        }
        return count;
    }
    private int dfs(int leftsum,int U){
        if(leftsum == 0){
           return 1;
        }
        if(dp[leftsum][U] != -1)return dp[leftsum][U];
        int res = 0;
        for(int v : moves[U]){
          res = (res + dfs(leftsum - 1,v)) % 1000000007;
        }
        dp[leftsum][U] = res;
        return dp[leftsum][U];
    }
}