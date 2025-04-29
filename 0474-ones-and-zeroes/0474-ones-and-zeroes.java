class Solution {
    private int[] countZeroesOnes(String str) {
    int[] count = new int[2];
    for (char c : str.toCharArray()) {
        count[c - '0']++;
    }
    return count;
}
    public int findMaxForm(String[] strs, int m, int n) {
         int[][] dp = new int[m + 1][n + 1];

    for (String str : strs) {
        int[] count = countZeroesOnes(str);
        int zeros = count[0], ones = count[1];

        for (int i = m; i >= zeros; i--) {
            for (int j = n; j >= ones; j--) {
                dp[i][j] = Math.max(dp[i][j], 1 + dp[i - zeros][j - ones]);
            }
        }
    }

    return dp[m][n];
    }
}