class Solution {
    int[][] dp;
    int[] prices;
    int fee;

    public int maxProfit(int[] prices, int fee) {
        this.prices = prices;
        this.fee = fee;
        int n = prices.length;
        dp = new int[n][2];
        for(int i = 0; i < n; i++){
            dp[i][0] = dp[i][1] = -1;
        }
        return dfs(0, 1);
    }

    private int dfs(int i, int canBuy){
        if (i == prices.length) return 0;
        if (dp[i][canBuy] != -1) return dp[i][canBuy];

        int profit;
        if(canBuy == 1){
            int buy = -prices[i] + dfs(i + 1, 0);
            int skip = dfs(i + 1, 1);
            profit = Math.max(buy, skip);
        } else{
            int sell = prices[i] - fee + dfs(i + 1, 1);
            int hold = dfs(i + 1, 0);
            profit = Math.max(sell, hold);
        }
        return dp[i][canBuy] = profit;
    }
}
