class Solution {
    static int[][] memo;
    static int solve(int i,int sum,int W, int val[], int wt[]){
        if(i >= val.length)return 0;
        if(memo[i][sum] != -1){
            return memo[i][sum];
        }
        int takeit = 0;
        if(sum + wt[i] <= W){
            takeit = val[i] + solve(i + 1,sum + wt[i],W,val,wt);
        }
        int skip = solve(i + 1,sum,W,val,wt);
        memo[i][sum] = Math.max(takeit,skip);
        return memo[i][sum];
    }
    static int knapsack(int W, int val[], int wt[]) {
        memo = new int[val.length][W + 1];
        for(int[] arr:memo)Arrays.fill(arr,-1);
        return solve(0,0,W,val,wt);
    }
}
