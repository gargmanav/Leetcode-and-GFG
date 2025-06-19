class Solution {
    int[][] directions = {{0,1}, {1,0}, {0,-1}, {-1,0}};
    int n;

    public int shortestBridge(int[][] grid) {
        n = grid.length;
        Queue<int[]> queue = new LinkedList<>();
        boolean found = false;

        // Step 1: Find first island and mark it as -1, also collect its boundary cells in queue
        for (int i = 0; i < n && !found; i++) {
            for (int j = 0; j < n && !found; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    found = true;
                }
            }
        }

        // Step 2: BFS from boundary to reach second island
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size-- > 0) {
                int[] cell = queue.poll();
                int x = cell[0], y = cell[1];

                for (int[] dir : directions) {
                    int nx = x + dir[0];
                    int ny = y + dir[1];

                    if (nx >= 0 && ny >= 0 && nx < n && ny < n) {
                        if (grid[nx][ny] == 1) {
                            return steps; // Found second island
                        }

                        if (grid[nx][ny] == 0) {
                            grid[nx][ny] = -1; // mark visited
                            queue.offer(new int[]{nx, ny});
                        }
                    }
                }
            }

            steps++;
        }

        return -1; // Should not reach here
    }

    // DFS to mark first island and store boundary cells into queue
    private void dfs(int[][] grid, int i, int j, Queue<int[]> queue) {
        if (i < 0 || j < 0 || i >= n || j >= n || grid[i][j] != 1) return;

        grid[i][j] = -1; // Mark as visited
        queue.offer(new int[]{i, j}); // Add to queue for BFS

        for (int[] dir : directions) {
            dfs(grid, i + dir[0], j + dir[1], queue);
        }
    }
}
