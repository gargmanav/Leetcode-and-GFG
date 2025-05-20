class Solution {
    private int[][] dp;

    private int solve(int amount, int[] coins, int index, int sum) {
        if (sum == amount) return 1;
        if (sum > amount || index >= coins.length) return 0;

        if (dp[index][sum] != -1) return dp[index][sum];

        int include = solve(amount, coins, index, sum + coins[index]);
        int exclude = solve(amount, coins, index + 1, sum);

        return dp[index][sum] = include + exclude;
    }

    public int change(int amount, int[] coins) {
        dp = new int[coins.length][amount + 1];
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= amount; j++) {
                dp[i][j] = -1;
            }
        }
        return solve(amount, coins, 0, 0);
    }
}