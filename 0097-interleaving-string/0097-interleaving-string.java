class Solution {
    int n, m, p;

    private boolean solve(int i, int j, int k, String s1, String s2, String s3, int[][][] memo) {
        if (i == n && j == m && k == p) return true;
        if (k >= p) return false;

        if (memo[i][j][k] != -1) return memo[i][j][k] == 1;

        boolean result = false;

        if (i < n && s1.charAt(i) == s3.charAt(k)) {
            result = solve(i + 1, j, k + 1, s1, s2, s3, memo);
        }

        if (!result && j < m && s2.charAt(j) == s3.charAt(k)) {
            result = solve(i, j + 1, k + 1, s1, s2, s3, memo);
        }

        memo[i][j][k] = result ? 1 : 0;
        return result;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        n = s1.length();
        m = s2.length();
        p = s3.length();

        if (p != n + m) return false;

        int[][][] memo = new int[n + 1][m + 1][p + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <= p; k++) {
                    memo[i][j][k] = -1;
                }
            }
        }

        return solve(0, 0, 0, s1, s2, s3, memo);
    }
}