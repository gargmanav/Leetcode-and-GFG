class Solution {
    int n,m;
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int[][] grid,int row,int col){
        grid[row][col] = 0;
        for(int[] dir : directions){
            int nr = dir[0] + row;
            int nc = dir[1] + col;
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                dfs(grid,nr,nc);
            }
        }
    }
    public int numEnclaves(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        for(int i = 0;i < m;i++){
            if(grid[i][0] == 1)dfs(grid,i,0);
            if(grid[i][n - 1] == 1)dfs(grid,i,n - 1);
        }
        for(int j = 0;j < n;j++){
            if(grid[0][j] == 1)dfs(grid,0,j);
            if(grid[m - 1][j] == 1)dfs(grid,m - 1,j);
        }
        int land = 0;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(grid[i][j] == 1){
                    land++;
                }
            }
        }
        return land;
    }
}