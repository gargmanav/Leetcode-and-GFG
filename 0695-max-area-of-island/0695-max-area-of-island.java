class Solution {
   
    private int dfs(int[][] grid,int i,int j,int n,int m){
        if(i < 0 || i >= n || j < 0 || j >= m || grid[i][j] != 1)return 0;
        grid[i][j] = 2;
        int area = 1;
        area += dfs(grid,i - 1,j,n,m);
        area += dfs(grid,i + 1,j,n,m);
        area += dfs(grid,i,j - 1,n,m);
        area += dfs(grid,i,j + 1,n,m);
        return area;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        int n = grid.length,m = grid[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea, dfs(grid,i,j,n,m));
                }
            }
        }
        return maxArea;
    }
}