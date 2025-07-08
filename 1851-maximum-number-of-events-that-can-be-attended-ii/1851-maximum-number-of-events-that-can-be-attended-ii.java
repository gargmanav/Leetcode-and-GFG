class Solution {
    public int maxValue(int[][] events, int k) {
        // Sort events by start time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        int n = events.length;
        // Memoization table: dp[i][k]
        int[][] dp = new int[n][k + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        
        return helper(0, k, events, dp);
    }
    
    private int helper(int i, int k, int[][] events, int[][] dp) {
        if (i >= events.length || k == 0) return 0;
        if (dp[i][k] != -1) return dp[i][k];

        // Binary search to find next event which starts after events[i][1]
        int next = binarySearch(events, events[i][1] + 1);
        
        // 2 options: take this event or skip it
        int take = events[i][2] + helper(next, k - 1, events, dp);
        int skip = helper(i + 1, k, events, dp);
        
        dp[i][k] = Math.max(take, skip);
        return dp[i][k];
    }

    // Find index of the first event whose start > target
    private int binarySearch(int[][] events, int target) {
        int low = 0, high = events.length;
        while (low < high) {
            int mid = (low + high) / 2;
            if (events[mid][0] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
