class Solution {
    private int findmin(int i, int[] prices,int[] memo) {
        if (i >= prices.length) return 0;
        if(memo[i] != -1){
            return memo[i];
        }
       int minSum = Integer.MAX_VALUE;
       for(int j = i + 1;j <= Math.min(prices.length,2 * (i + 1));j++){
        minSum = Math.min(minSum,prices[i] + findmin(j,prices,memo));
       }
       memo[i] =  minSum;
       return memo[i];
    }
    public int minimumCoins(int[] prices) {
        int[] memo = new int[prices.length];
        Arrays.fill(memo,-1);
        return findmin(0, prices,memo);
    }
}