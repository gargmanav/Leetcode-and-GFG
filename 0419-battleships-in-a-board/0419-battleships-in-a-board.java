class Solution {
    public int countBattleships(char[][] board) {
        int count = 0;
        int n = board.length,m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == '.')continue;

                if(i > 0 && board[i - 1][j] == 'X')continue;
                if(j > 0 && board[i][j - 1] == 'X')continue;
                count++;
            }
        }
        return count;
    }
}