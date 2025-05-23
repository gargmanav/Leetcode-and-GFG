class Solution {
    private boolean diffArrayTechnique(int[] nums, int[][] queries,int k){
        int n = nums.length;
    int[] diff = new int[n + 2];

    // Apply first 'k' queries
    for(int i = 0; i < k; i++){
        int l = queries[i][0];
        int r = queries[i][1];
        int v = queries[i][2];

        diff[l] += v;
        if (r + 1 < diff.length) {
            diff[r + 1] -= v;
        }
    }

    // Now calculate final array using prefix sum
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += diff[i];
        if (sum < nums[i]) {
            return false;
        }
    }

    return true;
    }
    public int minZeroArray(int[] nums, int[][] queries) {
        int l = 1;                      // minimum k = 1
        int r = queries.length;        // maximum k = queries.length
        int ans = -1;

        if(Arrays.stream(nums).allMatch(x -> x == 0))return 0;

        while(l <= r){
            int mid = l + (r - l) / 2;

            if(diffArrayTechnique(nums, queries, mid)){
                ans = mid;
                r = mid - 1; // try smaller k
            } else {
                l = mid + 1;
            }
        }

        return ans;
    }
}