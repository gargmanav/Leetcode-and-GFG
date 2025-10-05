class Solution {
    private int m, n;
    private int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m = heights.length;
        n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        // Pacific DFS
        for(int i=0;i<m;i++) dfs(heights, pacific, i, 0);
        for(int j=0;j<n;j++) dfs(heights, pacific, 0, j);

        // Atlantic DFS
        for(int i=0;i<m;i++) dfs(heights, atlantic, i, n-1);
        for(int j=0;j<n;j++) dfs(heights, atlantic, m-1, j);

        List<List<Integer>> res = new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        return res;
    }

    private void dfs(int[][] heights, boolean[][] visited, int i, int j){
        visited[i][j] = true;
        for(int[] dir: dirs){
            int ni = i + dir[0];
            int nj = j + dir[1];
            if(ni>=0 && nj>=0 && ni<m && nj<n && !visited[ni][nj] && heights[ni][nj] >= heights[i][j]){
                dfs(heights, visited, ni, nj);
            }
        }
    }
}
