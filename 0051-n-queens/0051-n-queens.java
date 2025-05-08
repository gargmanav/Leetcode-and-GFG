class Solution {
    private int N;
    private List<List<String>> result = new ArrayList<>();
    private void solve(char[][] board,int row){
        if(row >= N){
            List<String> temp = new ArrayList<>();
            for (char[] r : board) {
                temp.add(new String(r));
            }
            result.add(temp);
            return;
        }
        for(int i = 0;i<N;i++){
            if(isValid(board,row,i)){
                board[row][i] = 'Q';
                solve(board,row + 1);
                board[row][i] = '.';
            }
        }

    }
    private boolean isValid(char[][] board,int row,int col){
        //upward
        for(int i = row - 1;i >= 0;i--){
          if(board[i][col] == 'Q'){
            return false;
          }
        }
       //left diagonal
       for(int i = row - 1,j = col - 1;i >= 0 && j >= 0;i--,j--){
        if(board[i][j] == 'Q'){
            return false;
        }
       }

       //right diagonal
       for(int i = row - 1,j = col + 1;i >= 0 && j < N;i--,j++){
        if(board[i][j] == 'Q'){
            return false;
        }
       }
      return true;
    }
    public List<List<String>> solveNQueens(int n) {
        N = n;
        char[][] board = new char[n][n];
        for(char[] arr: board){
            Arrays.fill(arr,'.');
        }
        solve(board,0);
        return result;
    }
}