class Solution {
    public int countBattleships(char[][] board) {
      int count = 0;
        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                // Skip empty water
                if (board[i][j] == '.') continue;

                // Skip if it's a continuation of a ship from above or left
                if (i > 0 && board[i - 1][j] == 'X') continue;
                if (j > 0 && board[i][j - 1] == 'X') continue;

                // It's the start of a new ship
                count++;
            }
        }

        return count;  
    }
}