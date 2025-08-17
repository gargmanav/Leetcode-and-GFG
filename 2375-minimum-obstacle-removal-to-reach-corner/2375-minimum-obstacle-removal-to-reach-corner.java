class Solution {

    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public int minimumObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dist = new int[m][n];
        for(int[] arr : dist){
            Arrays.fill(arr,Integer.MAX_VALUE);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0] - b[0]);
    pq.add(new int[]{0,0,0});
    while(!pq.isEmpty()){
        int[] curr = pq.poll();
        int count = curr[0],row = curr[1],col = curr[2];
        if(row == m - 1 && col == n - 1)return count;
        for(int[] dir : directions){
            int nrow = row + dir[0],ncol = col + dir[1];
            if(nrow >= 0 && nrow < m && ncol >= 0 && ncol < n){
                if(dist[nrow][ncol] > count + grid[nrow][ncol]){
                    dist[nrow][ncol] = count + grid[nrow][ncol];
                    pq.add(new int[]{count + grid[nrow][ncol],nrow,ncol});
                }
            }
        }
    }
    return 0;
    }
}