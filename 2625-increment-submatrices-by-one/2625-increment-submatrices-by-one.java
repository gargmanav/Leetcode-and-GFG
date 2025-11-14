class Solution {
    public int[][] rangeAddQueries(int n, int[][] queries) {
        int[][] result = new int[n][n];

        // 2D difference array updates
        for (int[] query : queries) {
            int r1 = query[0], c1 = query[1], r2 = query[2], c2 = query[3];
            result[r1][c1] += 1;
            if (c2 + 1 < n) result[r1][c2 + 1] -= 1;
            if (r2 + 1 < n) result[r2 + 1][c1] -= 1;
            if (r2 + 1 < n && c2 + 1 < n) result[r2 + 1][c2 + 1] += 1;
        }

        // Row-wise prefix sum
        for (int i = 0; i < n; i++)
            for (int j = 1; j < n; j++)
                result[i][j] += result[i][j - 1];

        // Column-wise prefix sum
        for (int j = 0; j < n; j++)
            for (int i = 1; i < n; i++)
                result[i][j] += result[i - 1][j];

        return result;
    }
}