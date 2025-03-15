class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        Queue<int[]> que = new LinkedList<>();

        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 0){
                    que.add(new int[]{i,j});
                }
                else mat[i][j] = Integer.MAX_VALUE;
            }
        }
        int[][] adj = {{-1,0},{1,0},{0,-1},{0,1}};
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int i = temp[0];
            int j = temp[1];
            for(int[] dir : adj){
                int newX = dir[0] + i;
                int newY = dir[1] + j;
                if(newX >= 0 && newX < n && newY >= 0 && newY < m && mat[newX][newY] > mat[i][j] + 1){
                    mat[newX][newY] = mat[i][j] + 1;
                    que.add(new int[]{newX,newY}); 
                }
            }
        }
        return mat;
    }
}

class Pair{
    int i;
    int j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}