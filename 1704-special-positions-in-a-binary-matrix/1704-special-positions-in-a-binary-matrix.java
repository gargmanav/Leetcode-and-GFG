class Solution {
    int n , m;
    private boolean checkRowsColumns(int i,int j,int[][] mat){
        if(j + 1 < m){
            //right rows
        for(int right = j + 1;right < m;right++){
            if(mat[i][right] == 1){
                return false;
            }
        }
        }
        if(j - 1 > 0){
            //left rows
        for(int left = j - 1;left >= 0;left--){
            if(mat[i][left] == 1){
                return false;
            }
        }
        }
        if(i - 1 > 0){
            //top rows
        for(int top = i - 1;top >= 0;top--){
            if(mat[top][j] == 1){
                return false;
            }
        }
        }
        if(i + 1 < n){
            //bottom rows
        for(int bottom = i + 1;bottom < n;bottom++){
            if(mat[bottom][j] == 1){
                return false;
            }
        }
        }
        return true;
    }
    public int numSpecial(int[][] mat) {
        n = mat.length;
        m = mat[0].length;
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(mat[i][j] == 1){
                  if(checkRowsColumns(i,j,mat)){
                    count++;
                  }
                }
            }
        }
        return count;
    }
}