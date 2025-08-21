class Solution {
    public int findLatestStep(int[] arr, int m) {
        int n = arr.length;
        if (m == n) return n; // whole array forms size m at the end

        int[] len = new int[n + 2];  // length of group
        int res = -1;
        int count = 0;  // how many groups of size m exist

        for (int step = 0; step < n; step++) {
            int i = arr[step];
            int left = len[i - 1];
            int right = len[i + 1];
            int total = left + right + 1;

            // merge groups
            len[i - left] = len[i + right] = total;

            // update counts
            if (left == m) count--;  
            if (right == m) count--;  
            if (total == m) count++;

            if (count > 0) res = step + 1;
        }
        return res;
    }
}
