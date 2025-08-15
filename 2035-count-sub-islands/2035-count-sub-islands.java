class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    int m,n;
    private boolean dfs(int i,int j,int[][] grid1, int[][] grid2){
      if(i < 0 || j < 0 || i >= m || j >= n || grid2[i][j] == 0)return true;
      boolean result = true;
      if(grid1[i][j] == 0) result = false;
      grid2[i][j] = 0;
      for(int[] dir : directions){
        if(!dfs(dir[0] + i,dir[1] + j,grid1,grid2))result = false;
      }
      return result;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;
        int count = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(grid2[i][j] == 1){
                    if(dfs(i,j,grid1,grid2)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}