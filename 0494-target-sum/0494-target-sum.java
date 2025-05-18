class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) sum += num;
        
        // Check if it's possible to partition
        if ((sum + target) % 2 != 0 || sum < Math.abs(target)) return 0;
        
        int subsetSum = (sum + target) / 2;
        return countSubsets(nums, subsetSum);
    }
    
    private int countSubsets(int[] nums, int sum) {
        int[] dp = new int[sum + 1];
        dp[0] = 1;
        
        for (int num : nums) {
            for (int j = sum; j >= num; j--) {
                dp[j] += dp[j - num];
            }
        }
        
        return dp[sum];
    }
}