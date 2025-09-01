class Solution {
    public int[][] updateMatrix(int[][] mat) {
        Queue<int[]> que = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i,j});
                }else{
                    mat[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        while(!que.isEmpty()){
            int[] curr = que.poll();
            for(int[] dir : directions){
                int nr = dir[0] + curr[0];
                int nc = dir[1] + curr[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n){
                    if(mat[nr][nc] > mat[curr[0]][curr[1]] + 1){
                       mat[nr][nc] = mat[curr[0]][curr[1]] + 1;
                       que.add(new int[]{nr,nc});
                    }
                }
            }
        }
        return mat;
    }
}