import java.util.*;

class Solution {
    public int maxDistance(int[][] grid) {
        int n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean hasWater = false, hasLand = false;

        // Step 1: Add all land cells to the queue
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                    hasLand = true;
                } else {
                    hasWater = true;
                }
            }
        }

        // Edge case: no land or no water
        if (!hasLand || !hasWater) return -1;

        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
        int distance = -1;

        // Step 2: BFS from all land cells
        while (!queue.isEmpty()) {
            int size = queue.size();
            distance++;
            for (int s = 0; s < size; s++) {
                int[] cell = queue.poll();
                for (int[] d : dirs) {
                    int ni = cell[0] + d[0];
                    int nj = cell[1] + d[1];
                    if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] == 0) {
                        grid[ni][nj] = 1; // mark as visited (convert to land)
                        queue.offer(new int[]{ni, nj});
                    }
                }
            }
        }

        return distance;
    }
}
