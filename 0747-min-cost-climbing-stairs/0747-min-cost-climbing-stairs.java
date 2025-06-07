class Solution {
    public int solve(int index, int[] cost, int[] dp) {
        if (index >= cost.length) return 0;
        if (dp[index] != -1) return dp[index];
        return dp[index] = cost[index] + Math.min(solve(index + 1, cost, dp), solve(index + 2, cost, dp));
    }

    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return Math.min(solve(0, cost, dp), solve(1, cost, dp));
    }
}

