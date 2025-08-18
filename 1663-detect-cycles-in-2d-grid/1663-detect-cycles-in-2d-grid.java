class Solution {
    int m,n;
    private int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    private boolean dfs(char[][] grid,boolean[][] visited,int row,int col,int prow,int pcol){
        visited[row][col] = true;
        for(int[] dir : directions){
          int nrow = dir[0] + row;
          int ncol = dir[1] + col;
          if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n && grid[nrow][ncol] == grid[row][col]){
           if (visited[nrow][ncol]) {
                  if (nrow != prow || ncol != pcol) return true;
              } else {
                  if (dfs(grid, visited, nrow, ncol, row, col)) return true;
             }
          }
        }
        return false;
    }
    public boolean containsCycle(char[][] grid) {
        m = grid.length;
        n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j < n;j++){
                if(!visited[i][j]){
                    if(dfs(grid,visited,i,j,-1,-1) == true){
                        return true;
                    }
                }
            }
        }
        return false;
    }
}