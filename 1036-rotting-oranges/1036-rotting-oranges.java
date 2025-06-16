class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};

    public int orangesRotting(int[][] grid) {
        int freshOranges = 0;
        int rottenOranges = 0;
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    freshOranges++;
                }else if(grid[i][j] == 2){
                    que.add(new int[]{i,j});
                }
            }
        }
       
       int time = 0;
       while(!que.isEmpty()){
         int size = que.size();
         boolean flag = false;
         for(int i = 0;i < size;i++){
            int[] arr = que.poll();
            int a = arr[0];
            int b = arr[1];
            for(int[] newarr : directions){
                int na = a + newarr[0];
                int nb = b + newarr[1];
                if(na >= 0 && na < n && nb >= 0 && nb < m && grid[na][nb] == 1){
                    que.add(new int[]{na,nb});
                    grid[na][nb] = 2;
                    freshOranges--;
                    flag = true;
                }
            }
            
         }
         if(flag)time++;
    }
    return freshOranges == 0 ? time : -1;
}

}