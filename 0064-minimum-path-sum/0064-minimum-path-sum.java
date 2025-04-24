class Solution {
    private int dfs(int i,int j,int[][] grid,int n,int m,int[][] dp){
        if (i >= n || j >= m) return Integer.MAX_VALUE;

        if (i == n - 1 && j == m - 1) {
            return grid[i][j]; // Final cell included in sum
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int down = dfs(i + 1, j, grid, n, m,dp);
        int right = dfs(i, j + 1, grid, n, m,dp);

        return dp[i][j] =  grid[i][j] + Math.min(down, right);
    }
    public int minPathSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return dfs(0,0,grid,n,m,dp);
    }
}