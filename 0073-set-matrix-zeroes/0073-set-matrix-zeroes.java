class Solution {
    public void setZeroes(int[][] matrix) {
        int a = matrix.length;
        int b = matrix[0].length;
        boolean[] row = new boolean[a];
        boolean[] col = new boolean[b];

        for(int i = 0;i<a;i++){
            for(int j = 0;j<b;j++){
                if(matrix[i][j] == 0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i = 0;i<a;i++){
            if(row[i]){
                for(int j = 0;j<b;j++){
                    matrix[i][j] = 0;
                }
            }
        }
        
        for(int i = 0;i< b;i++){
            if(col[i]){
                for(int j = 0;j< a;j++){
                    matrix[j][i] = 0;
                }
            }
        }
    }
}