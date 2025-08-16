class Solution {
    public int[][] findFarmland(int[][] land) {
        int m = land.length, n = land[0].length;
        List<int[]> res = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] rect = dfs(land, i, j, m, n);
                    res.add(new int[]{i, j, rect[0], rect[1]});
                }
            }
        }
        return res.toArray(new int[0][]);
    }
    private int[] dfs(int[][] land, int i, int j, int m, int n) {
        int row = i, col = j;
        land[i][j] = 0;
        if (i + 1 < m && land[i + 1][j] == 1) {
            int[] down = dfs(land, i + 1, j, m, n);
            row = Math.max(row, down[0]);
            col = Math.max(col, down[1]);
        }
        if (j + 1 < n && land[i][j + 1] == 1) {
            int[] right = dfs(land, i, j + 1, m, n);
            row = Math.max(row, right[0]);
            col = Math.max(col, right[1]);
        }
        return new int[]{row, col};
    }
}