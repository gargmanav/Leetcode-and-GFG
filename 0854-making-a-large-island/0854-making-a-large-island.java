class Solution {
    int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

    public int largestIsland(int[][] grid) {
        int n = grid.length;
        int id = 2; // Island IDs start from 2 to differentiate from 0 and 1
        Map<Integer, Integer> islandSize = new HashMap<>();

        // 1. Label all islands and record their sizes
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int size = dfs(grid, i, j, id);
                    islandSize.put(id, size);
                    id++;
                }
            }
        }

        int maxSize = 0;
        boolean hasZero = false;

        // 2. Try changing each 0 to 1 and calculate potential island size
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    hasZero = true;
                    Set<Integer> seen = new HashSet<>();
                    int newSize = 1;

                    for (int[] d : directions) {
                        int ni = i + d[0], nj = j + d[1];
                        if (ni >= 0 && ni < n && nj >= 0 && nj < n && grid[ni][nj] > 1) {
                            int neighborId = grid[ni][nj];
                            if (!seen.contains(neighborId)) {
                                seen.add(neighborId);
                                newSize += islandSize.get(neighborId);
                            }
                        }
                    }

                    maxSize = Math.max(maxSize, newSize);
                }
            }
        }

        // 3. If there is no 0, whole grid is one island
        return hasZero ? maxSize : n * n;
    }

    private int dfs(int[][] grid, int i, int j, int id) {
        int n = grid.length;
        if (i < 0 || i >= n || j < 0 || j >= n || grid[i][j] != 1) {
            return 0;
        }

        grid[i][j] = id;
        int size = 1;

        for (int[] d : directions) {
            size += dfs(grid, i + d[0], j + d[1], id);
        }

        return size;
    }
}