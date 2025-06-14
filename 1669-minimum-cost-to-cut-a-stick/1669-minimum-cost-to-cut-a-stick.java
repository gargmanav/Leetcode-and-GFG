class Solution {
    public int minCost(int n, int[] cuts) {
         int m = cuts.length;
        int[] newCuts = new int[m + 2];
        
        // Add 0 and n to the list of cuts
        newCuts[0] = 0;
        newCuts[m + 1] = n;
        for (int i = 0; i < m; i++) {
            newCuts[i + 1] = cuts[i];
        }
        Arrays.sort(newCuts);
        
        int[][] dp = new int[m + 2][m + 2];
        
        // Bottom-up DP
        for (int len = 2; len <= m + 1; len++) {
            for (int i = 0; i + len <= m + 1; i++) {
                int j = i + len;
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[i][k] + dp[k][j] + (newCuts[j] - newCuts[i])
                    );
                }
            }
        }
        
        return dp[0][m + 1];
    }
}