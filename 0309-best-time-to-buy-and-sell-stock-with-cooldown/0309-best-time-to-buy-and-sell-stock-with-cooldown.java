class Solution {
    private int[][] memo = new int[5001][2];
    private int solve(int[] prices,int index,int n,boolean buy){
        if(index >= n){
            return 0;
        }
        if(memo[index][buy ? 1 : 0] != -1){
            return memo[index][buy ? 1 : 0];
        }
        int profit = 0;
        if(buy){
            int take = solve(prices,index + 1,n,false) - prices[index];
            int not_take = solve(prices,index + 1,n,true);
            profit = Math.max(profit,Math.max(take,not_take));
        }else{
            int sell = solve(prices,index + 2,n,true) + prices[index];;
            int not_sell = solve(prices,index + 1,n,false);
            profit = Math.max(profit,Math.max(sell,not_sell));
        }
        return memo[index][buy ? 1 : 0] = profit;
    }
    public int maxProfit(int[] prices) {
        for(int[] arr : memo){
            Arrays.fill(arr,-1);
        }
        int n = prices.length;
        return solve(prices,0,n,true);
    }
}