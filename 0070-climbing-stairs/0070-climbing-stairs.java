class Solution {
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // dp[0] = 1;
        // dp[1] = 1;
        // if(n == 1 || n == 0)return 1;
        // for(int i=2;i<=n;i++){
        //     dp[i] = dp[i - 1] + dp[i - 2];
        // }
        // return dp[n];


        int prev = 1;
        int prevprev = 1;

        for(int i = 2;i<=n;i++){
            int curr = prev + prevprev;
             prevprev = prev;
             prev = curr;
        }
        return prev;
    }
}