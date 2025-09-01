class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int rotten = 0;
        int fresh = 0;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0;i < m;i++){
            for(int j = 0;j < n;j++){
               if(grid[i][j] == 2){
                rotten++;
                que.add(new int[]{i,j});
               }else if(grid[i][j] == 1){
                fresh++;
               }
            }
        }
        if(fresh == 0)return 0;
        int time = 0;
        while(!que.isEmpty()){
            int size = que.size();
            if(fresh == 0)return time;
            time++;
            for(int i = 0;i < size;i++){
              int[] curr = que.poll();
              for(int[] dir : directions){
                int nr = curr[0] + dir[0];
                int nc = curr[1] + dir[1];
                if(nr >= 0 && nr < m && nc >= 0 && nc < n && grid[nr][nc] == 1){
                    fresh--;
                    grid[nr][nc] = 2;
                    que.add(new int[]{nr,nc});
                }
              }
            }
        }
        return -1;
    }
}