class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
         int n = nums.length;
        boolean[] mark = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] == key) {
                int start = Math.max(0, i - k);
                int end = Math.min(n - 1, i + k);
                for (int j = start; j <= end; j++) {
                    mark[j] = true;
                }
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (mark[i]) {
                res.add(i);
            }
        }

        return res;
    }
}