class Solution {
    private int m,n;
    private final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int[][] image, int sr, int sc,int curr, int color){
        if(curr == color)return;
        image[sr][sc] = color;
        for(int[] dir : directions){
            int nr = sr + dir[0];
            int nc = sc + dir[1];
            if(nr >= 0 && nr < m && nc >= 0 && nc < n && image[nr][nc] == curr){
                dfs(image,nr,nc,curr,color);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color)  { 
        m = image.length;
        n = image[0].length;
        int curr = image[sr][sc];
        dfs(image,sr,sc,curr,color);
        return image;
    }
}