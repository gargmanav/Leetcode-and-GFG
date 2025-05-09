class Solution {
    int n,m;
    private int[][] dir = {{0,1},{1,0},{0,-1},{-1,0}};
    private void dfs(int[][] image, int sr, int sc, int color,int originalColor){
        if(image[sr][sc] != originalColor){
            return;
        }
        if(image[sr][sc] == originalColor){
            image[sr][sc] = color;
        }
        for(int[] arr : dir){
            int nr = sr + arr[0];
            int nc = sc + arr[1];
            if(nr >= 0 && nr < n && nc >= 0 && nc < m && image[nr][nc] == originalColor){
                dfs(image,nr,nc,color,originalColor);
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        n = image.length;
        m = image[0].length;
        int originalColor = image[sr][sc];
        if(color != originalColor){
            dfs(image,sr,sc,color,originalColor);
        }
        return image;
    }
}