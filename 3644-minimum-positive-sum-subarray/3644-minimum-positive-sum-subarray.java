class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int minPositiveSum = Integer.MAX_VALUE;
        
        // Calculate prefix sums for efficient subarray sum calculation
        int[] prefixSum = new int[n + 1];
        prefixSum[0] = 0;
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums.get(i);
        }
        
        // Check all possible subarrays with lengths from l to r
        for (int len = l; len <= r; len++) {
            for (int start = 0; start + len <= n; start++) {
                int end = start + len;
                int sum = prefixSum[end] - prefixSum[start];
                
                // Update minimum positive sum
                if (sum > 0) {
                    minPositiveSum = Math.min(minPositiveSum, sum);
                }
            }
        }
        
        return minPositiveSum == Integer.MAX_VALUE ? -1 : minPositiveSum;
    }
}