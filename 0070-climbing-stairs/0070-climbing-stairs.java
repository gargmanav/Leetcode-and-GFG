class Solution {
    int[] memo;
    private int count(int curr,int n){
        if(curr > n)return 0;
        if(n == curr)return 1;
        if(memo[curr] != -1){
            return memo[curr];
        }
        memo[curr] = count(curr + 1,n) + count(curr + 2,n);
        return memo[curr];
    }
    public int climbStairs(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo,-1);
        return count(0,n);
    }
}