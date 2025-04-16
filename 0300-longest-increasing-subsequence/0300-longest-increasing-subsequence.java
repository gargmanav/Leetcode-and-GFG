class Solution {
    private int LIS(int index,int prev_index,int[][] dp,int[] nums){
        if(index == nums.length)return 0;
        if(dp[index][prev_index+1] != -1){
            return dp[index][prev_index + 1];
        }
        int len = 0 + LIS(index + 1,prev_index,dp,nums);
        if(prev_index == -1 || nums[index] > nums[prev_index]){
            len = Math.max(len,1 + LIS(index + 1,index,dp,nums));
        }
        return dp[index][prev_index + 1] = len;
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return LIS(0,-1,dp,nums);
    }
}