class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int[] dp = new int[days.length]; // dp[i] = min cost from day i to end
        Arrays.fill(dp, -1);
        return helper(0, days, costs, dp);
    }

    private int helper(int i, int[] days, int[] costs, int[] dp) {
        if (i >= days.length) return 0;
        if (dp[i] != -1) return dp[i];

        // Option 1: Buy 1-day pass
        int cost1 = costs[0] + helper(i + 1, days, costs, dp);

        // Option 2: Buy 7-day pass
        int j = i;
        while (j < days.length && days[j] < days[i] + 7) j++;
        int cost7 = costs[1] + helper(j, days, costs, dp);

        // Option 3: Buy 30-day pass
        j = i;
        while (j < days.length && days[j] < days[i] + 30) j++;
        int cost30 = costs[2] + helper(j, days, costs, dp);

        dp[i] = Math.min(cost1, Math.min(cost7, cost30));
        return dp[i];
    }
}