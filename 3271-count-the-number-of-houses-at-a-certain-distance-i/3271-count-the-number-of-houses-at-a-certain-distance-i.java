class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[] ans = new int[n];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == j) continue;
                int direct = Math.abs(i - j);
                int viaShortcut = Math.min(Math.abs(i - x) + 1 + Math.abs(y - j),
                                           Math.abs(i - y) + 1 + Math.abs(x - j));
                int minDist = Math.min(direct, viaShortcut);
                ans[minDist - 1]++;
            }
        }
        return ans;
    }
}