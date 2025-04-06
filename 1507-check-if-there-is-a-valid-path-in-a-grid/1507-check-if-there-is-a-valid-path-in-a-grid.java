class Solution {
    private static final int[][][] DIRS = {
        {}, // 0 - dummy
        {{0, -1}, {0, 1}},     // type 1
        {{-1, 0}, {1, 0}},     // type 2
        {{0, -1}, {1, 0}},     // type 3
        {{0, 1}, {1, 0}},      // type 4
        {{0, -1}, {-1, 0}},    // type 5
        {{0, 1}, {-1, 0}}      // type 6
    };

    public boolean hasValidPath(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, 0});
        visited[0][0] = true;

        while (!q.isEmpty()) {
            int[] curr = q.poll();
            int i = curr[0], j = curr[1];
            if (i == m - 1 && j == n - 1) return true;

            int currType = grid[i][j];

            for (int[] dir : DIRS[currType]) {
                int ni = i + dir[0];
                int nj = j + dir[1];

                if (ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]) {
                    int nextType = grid[ni][nj];
                    for (int[] rev : DIRS[nextType]) {
                        if (ni + rev[0] == i && nj + rev[1] == j) {
                            visited[ni][nj] = true;
                            q.offer(new int[]{ni, nj});
                        }
                    }
                }
            }
        }

        return false;
    }
}