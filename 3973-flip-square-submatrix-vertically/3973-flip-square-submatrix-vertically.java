class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        // Reverse rows inside the k×k submatrix
        for (int i = 0; i < k / 2; i++) {
            int r1 = x + i;
            int r2 = x + (k - 1 - i);
            for (int col = y; col < y + k; col++) {
                int temp = grid[r1][col];
                grid[r1][col] = grid[r2][col];
                grid[r2][col] = temp;
            }
        }
        return grid;
    }
}
