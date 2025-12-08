class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        long[] prefix = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + damage[i - 1];
        }

        long ans = 0;

        for (int i = 1; i <= n; i++) {

            long need = prefix[i] + requirement[i - 1] - hp;

            int k = lowerBound(prefix, need, 0, i - 1);

            if (k != -1) {
                ans += (i - k);
            }
        }

        return ans;
    }
    private int lowerBound(long[] prefix, long target, int left, int right) {
        int ans = -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (prefix[mid] >= target) {
                ans = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return ans;
    }
}
