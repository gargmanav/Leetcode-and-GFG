class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1]; // extra space to handle j+1

        for (int[] query : queries) {
            int i = query[0];
            int j = query[1];
            if (i < 0 || j >= n || i > j) return false;

            diff[i] -= 1;
            if (j + 1 < n) {
                diff[j + 1] += 1;
            }
        }

        // Apply prefix sum and update nums
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += diff[i];
            nums[i] += sum;
            if (nums[i] > 0) return false; // check if not zero
        }

        return true;
    }
}