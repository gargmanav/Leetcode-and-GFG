class Solution {
    private int[][] directions = {{1,0},{0,1},{-1,0},{0,-1}};
    
    private boolean dfs(int i, int j, int pi, int pj, char[][] grid, boolean[][] visited, char ch) {
        visited[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0];
            int nj = j + dir[1];

            if (ni >= 0 && ni < grid.length && nj >= 0 && nj < grid[0].length && grid[ni][nj] == ch) {
                if (!visited[ni][nj]) {
                    if (dfs(ni, nj, i, j, grid, visited, ch)) return true;
                } else if (ni != pi || nj != pj) {
                    // Found a visited cell that is not the parent → cycle!
                    return true;
                }
            }
        }
        return false;
    }

    public boolean containsCycle(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (dfs(i, j, -1, -1, grid, visited, grid[i][j])) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
}
