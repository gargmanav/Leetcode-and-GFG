class Solution {
    int[] dp;
    int[] costing;
    int[] daying;
    private int helper(int index){
        if(index >= daying.length){
            return 0;
        }
        if(dp[index] != -1)return dp[index];
        int first = costing[0] + helper(index + 1);
        int j = index;
        while(j < daying.length && daying[j] < daying[index] + 7){
            j++;
        }
        int second = costing[1] + helper(j);
        
        int k = index;
        while(k < daying.length && daying[k] < daying[index] + 30){
            k++;
        }
        int third = costing[2] + helper(k);
        dp[index] = Math.min(first,Math.min(second,third));
        return dp[index];
    }
    public int mincostTickets(int[] days, int[] costs) {
        this.dp = new int[days.length];
        this.daying = days;
        this.costing = costs;
        Arrays.fill(dp,-1);
        return helper(0);
    }
}