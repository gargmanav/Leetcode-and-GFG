class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums); // Sort the numbers first

        int[] dp = new int[n]; // dp[i] = size of largest subset ending at i
        int[] prev = new int[n]; // to track previous index in subset

        Arrays.fill(dp, 1);  // each number is a subset of length 1
        Arrays.fill(prev, -1);

        int maxIndex = 0;

        // DP computation
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    prev[i] = j;
                }
            }
            // update maxIndex to point to largest subset end
            if (dp[i] > dp[maxIndex]) {
                maxIndex = i;
            }
        }

        // Build the result by backtracking from maxIndex
        List<Integer> result = new ArrayList<>();
        while (maxIndex != -1) {
            result.add(nums[maxIndex]);
            maxIndex = prev[maxIndex];
        }

        Collections.reverse(result); // To return in increasing order
        return result;
    }
}