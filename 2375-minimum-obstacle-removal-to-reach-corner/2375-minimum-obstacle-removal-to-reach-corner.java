import java.util.*;

class Solution {
    private int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    
    public int minimumObstacles(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dist = new int[m][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        
        Deque<int[]> dq = new ArrayDeque<>();
        dq.offer(new int[]{0, 0});
        dist[0][0] = 0;
        
        while (!dq.isEmpty()) {
            int[] cur = dq.pollFirst();
            int x = cur[0], y = cur[1];
            
            for (int[] d : directions) {
                int nx = x + d[0], ny = y + d[1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;
                
                int newCost = dist[x][y] + grid[nx][ny];
                if (newCost < dist[nx][ny]) {
                    dist[nx][ny] = newCost;
                    if (grid[nx][ny] == 1) {
                        dq.offerLast(new int[]{nx, ny}); // obstacle → back
                    } else {
                        dq.offerFirst(new int[]{nx, ny}); // free → front
                    }
                }
            }
        }
        
        return dist[m-1][n-1];
    }
}
