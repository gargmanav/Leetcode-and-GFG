class Solution {
    public int swimInWater(int[][] grid) {
       int n = grid.length;
        // Min-heap based on elevation (time)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        boolean[][] visited = new boolean[n][n];
        
        // Add starting point [time, row, col]
        pq.offer(new int[]{grid[0][0], 0, 0});
        
        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int time = curr[0], r = curr[1], c = curr[2];
            
            if (visited[r][c]) continue;
            visited[r][c] = true;
            
            if (r == n - 1 && c == n - 1) {
                return time;
            }
            
            for (int[] dir : dirs) {
                int nr = r + dir[0], nc = c + dir[1];
                if (nr >= 0 && nr < n && nc >= 0 && nc < n && !visited[nr][nc]) {
                    // We wait until the water rises to grid[nr][nc]
                    pq.offer(new int[]{Math.max(time, grid[nr][nc]), nr, nc});
                }
            }
        }
        
        return -1; // Should never reach here  
    }
}