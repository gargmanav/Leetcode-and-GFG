class Solution {
    private int helper(int[][] events, int k, int index, int[][] dp){
        if(index >= events.length || k == 0){
            return 0;
        }

        if(dp[index][k] != -1){
            return dp[index][k];
        }

        int ind = binarysearch(events, events[index][1] + 1);

        int take = events[index][2] + helper(events, k - 1, ind, dp);
        int not_take = helper(events, k, index + 1, dp);

        return dp[index][k] = Math.max(take, not_take);
    }

    private int binarysearch(int[][] events, int target){
        int low = 0, high = events.length - 1;
        while(low <= high){
            int mid = low + (high - low) / 2;
            if(events[mid][0] >= target){
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        int[][] dp = new int[n][k + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return helper(events, k, 0, dp);
    }
}
