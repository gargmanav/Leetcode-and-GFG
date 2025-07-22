class Solution {
    int[] memo;
    private int findmincost(int index,int[] cost){
        if(index < 0){
            return 0;
        }
        if(memo[index] != -1){
            return memo[index];
        }
        memo[index] = cost[index] + Math.min(findmincost(index - 1,cost),findmincost(index - 2,cost));
        return memo[index];
    }
    public int minCostClimbingStairs(int[] cost) {
       int n = cost.length;
       memo = new int[n];
       Arrays.fill(memo,-1);
       if(n == 0 || n == 1)return cost[n];
       return Math.min(findmincost(n - 1,cost),findmincost(n - 2,cost));
    }
}