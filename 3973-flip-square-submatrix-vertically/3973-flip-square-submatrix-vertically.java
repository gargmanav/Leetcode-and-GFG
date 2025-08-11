class Solution {
    public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
        int a = k + 1;
        for(int i = 0;i < k/2; i++){
            a--;
           for(int j = 0;j<k;j++){
              int temp = grid[x + i][y + j];
              grid[x + i][y + j] = grid[x + i + a - 1][y + j];
              grid[x + i + a - 1][y + j] = temp;
           }
        }
        return grid;
    }
}