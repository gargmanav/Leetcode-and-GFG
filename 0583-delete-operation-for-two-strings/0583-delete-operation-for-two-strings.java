class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        
        // dp[i][j] = length of LCS of word1[0..i-1] and word2[0..j-1]
        int[][] dp = new int[n + 1][m + 1];
        
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1]; // Match, add 1 to LCS
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // No match, take max
                }
            }
        }
        
        int lcsLength = dp[n][m];
        return n + m - 2 * lcsLength; // Minimum deletions
    }
}
