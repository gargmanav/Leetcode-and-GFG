class Solution {
    int[][][] dp;
    int MAX = Integer.MAX_VALUE / 2;

    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        // dp[i][j][k]: min cost to paint from house i to end with j as prev color and k neighborhoods left
        dp = new int[m][n + 1][target + 1];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j <= n; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        int ans = helper(0, 0, target, houses, cost, m, n);
        return ans >= MAX ? -1 : ans;
    }

    private int helper(int i, int prevColor, int targetLeft, int[] houses, int[][] cost, int m, int n) {
        if (targetLeft < 0) return MAX;
        if (i == m) return targetLeft == 0 ? 0 : MAX;

        if (dp[i][prevColor][targetLeft] != -1)
            return dp[i][prevColor][targetLeft];

        int ans = MAX;

        if (houses[i] != 0) {
            // Already painted
            int newTarget = targetLeft - (houses[i] != prevColor ? 1 : 0);
            ans = helper(i + 1, houses[i], newTarget, houses, cost, m, n);
        } else {
            // Not painted, try all colors
            for (int color = 1; color <= n; color++) {
                int paintCost = cost[i][color - 1];
                int newTarget = targetLeft - (color != prevColor ? 1 : 0);
                int totalCost = paintCost + helper(i + 1, color, newTarget, houses, cost, m, n);
                ans = Math.min(ans, totalCost);
            }
        }

        dp[i][prevColor][targetLeft] = ans;
        return ans;
    }
}
