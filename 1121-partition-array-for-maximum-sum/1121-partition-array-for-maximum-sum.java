class Solution {
    public int maxSumAfterPartitioning(int[] arr, int k) {
    int n = arr.length;
    Integer[] dp = new Integer[n];
    return helper(0, arr, k, dp);
}

private int helper(int i, int[] arr, int k, Integer[] dp) {
    if (i == arr.length) return 0;
    if (dp[i] != null) return dp[i];

    int currMax = 0;
    int maxSum = 0;

    for (int j = i; j < Math.min(i + k, arr.length); j++) {
        currMax = Math.max(currMax, arr[j]);
        int len = j - i + 1;
        int total = currMax * len + helper(j + 1, arr, k, dp);
        maxSum = Math.max(maxSum, total);
    }

    return dp[i] = maxSum;
}

}