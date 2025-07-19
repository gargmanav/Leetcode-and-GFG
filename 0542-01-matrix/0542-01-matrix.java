class Solution {
    int m,n;
    private final int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int[][] updateMatrix(int[][] mat) {
        m = mat.length;
        n = mat[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE/2;
                }
            }
        }
        while(!que.isEmpty()){
            int[] temp = que.poll();
            for(int[] dir : directions){
                int nr = temp[0] + dir[0];
                int nc = temp[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && mat[nr][nc] > mat[temp[0]][temp[1]] + 1){
                   mat[nr][nc] = mat[temp[0]][temp[1]] + 1;
                   que.add(new int[]{nr,nc});
                }
            }
        }
        return mat;
    }
}