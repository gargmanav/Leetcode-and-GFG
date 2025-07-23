class Solution {
    public int minimumCoins(int[] prices) {
        int n = prices.length;
        Integer[] dp = new Integer[n];
        return helper(0, prices, dp);
    }

    private int helper(int i, int[] prices, Integer[] dp) {
        int n = prices.length;
        if (i >= n) return 0; // base case: already at or beyond the end
        if (dp[i] != null) return dp[i];

        int minCost = Integer.MAX_VALUE;

        // You pay prices[i], then can jump to i+1 to 2*(i+1)
        for (int j = i + 1; j <= Math.min(n, 2 * (i + 1)); j++) {
            minCost = Math.min(minCost, prices[i] + helper(j, prices, dp));
        }

        dp[i] = minCost;
        return minCost;
    }
}
