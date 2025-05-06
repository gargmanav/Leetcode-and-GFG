class Solution {
    int[][] dp;
    int m, n;
    public int calculateMinimumHP(int[][] dungeon) {
        n = dungeon.length;
        m = dungeon[0].length;
        dp = new int[n][m];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return dfs(0, 0, dungeon);
    }
    private int dfs(int i, int j,int[][] dungeon){
        if(i >= n || j >= m)return Integer.MAX_VALUE;
        if(i == n - 1 && j == m - 1){
            return Math.max(1, 1 - dungeon[i][j]);
        }
        if(dp[i][j] != -1)return dp[i][j];
        int right = dfs(i,j + 1,dungeon);
        int bottom = dfs(i + 1,j,dungeon);
        int minNext = Math.min(right, bottom);
        int need = minNext - dungeon[i][j];

        dp[i][j] = Math.max(1, need);
        return dp[i][j];
    }
}