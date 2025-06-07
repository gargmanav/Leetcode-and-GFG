class Solution {
    int[][] dp;

    public boolean isPrec(String first, String second) {
        int N = first.length();
        int M = second.length();
        if (N >= M || M - N != 1) return false;
        int i = 0, j = 0;
        while (i < N && j < M) {
            if (first.charAt(i) == second.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == N;
    }

    public int LIS(int prev, int curr, String[] words) {
        if (curr >= words.length) return 0;

        if (dp[prev + 1][curr] != -1) return dp[prev + 1][curr];

        int take = 0;
        if (prev == -1 || isPrec(words[prev], words[curr])) {
            take = 1 + LIS(curr, curr + 1, words);
        }

        int skip = LIS(prev, curr + 1, words);
        return dp[prev + 1][curr] = Math.max(take, skip);
    }

    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        dp = new int[words.length + 1][words.length];
        for (int[] row : dp) Arrays.fill(row, -1);
        return LIS(-1, 0, words);
    }
}