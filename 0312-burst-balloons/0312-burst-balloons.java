class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;

        // Extend the array to handle edges easily
        int[] arr = new int[n + 2];
        arr[0] = 1;
        arr[n + 1] = 1;

        // Copy original nums into the extended array
        for (int i = 0; i < n; i++) {
            arr[i + 1] = nums[i];
        }

        // dp[i][j] will store the max coins from arr[i] to arr[j]
        int[][] dp = new int[n + 2][n + 2];

        // Length of the subarray
        for (int len = 2; len < n + 2; len++) {
            for (int left = 0; left < n + 2 - len; left++) {
                int right = left + len;
                // Try bursting each balloon in the range (left, right)
                for (int k = left + 1; k < right; k++) {
                    dp[left][right] = Math.max(dp[left][right],
                        arr[left] * arr[k] * arr[right] + dp[left][k] + dp[k][right]);
                }
            }
        }

        // Final result is from (0, n+1) as those are the new boundaries
        return dp[0][n + 1];
    }
}