class Solution {
    public boolean countMatrix(int i, int j, int k, int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;

        // Check bounds
        if (i + k > n || j + k > m) return false;

        // Check all cells in k x k square
        for (int x = i; x < i + k; x++) {
            for (int y = j; y < j + k; y++) {
                if (matrix[x][y] == 0) return false;
            }
        }

        return true;
    }
    public int countSquares(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int count = 0;
        for(int k = 1;k<=Math.min(n,m);k++){
            for(int i = 0;i<=n - k;i++){
                for(int j = 0;j<=m - k;j++){
                    if(countMatrix(i,j,k,matrix)){
                        count++;
                    }
                }
            }
        }
        return count;
    }
}