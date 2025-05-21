class Solution {
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int m = grid.size();
        int n = grid.get(0).size();

        // visited[i][j] = max health reached at cell (i,j)
        int[][] visited = new int[m][n];
        for (int[] row : visited) Arrays.fill(row, -1);

        Queue<int[]> queue = new LinkedList<>();
        int startCost = grid.get(0).get(0); // 1 if unsafe, 0 if safe
        int remainingHealth = health - startCost;

        if (remainingHealth <= 0) return false;

        queue.offer(new int[]{0, 0, remainingHealth});
        visited[0][0] = remainingHealth;

        int[][] dirs = {{0,1}, {1,0}, {0,-1}, {-1,0}};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            int i = curr[0], j = curr[1], h = curr[2];

            // Reached destination with health ≥ 1
            if (i == m - 1 && j == n - 1 && h >= 1) return true;

            for (int[] dir : dirs) {
                int ni = i + dir[0], nj = j + dir[1];
                if (ni < 0 || ni >= m || nj < 0 || nj >= n) continue;

                int cost = grid.get(ni).get(nj);
                int nextHealth = h - cost;

                // Only proceed if health stays positive AND this path gives us more remaining health
                if (nextHealth > 0 && nextHealth > visited[ni][nj]) {
                    visited[ni][nj] = nextHealth;
                    queue.offer(new int[]{ni, nj, nextHealth});
                }
            }
        }

        return false;
    }
}