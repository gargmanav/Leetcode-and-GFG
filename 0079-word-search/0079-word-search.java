class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, int idx) {
        // base case: word is completely matched
        if (idx == word.length()) {
            return true;
        }

        // boundary check and character match check
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length ||
            board[i][j] != word.charAt(idx)) {
            return false;
        }

        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // explore all 4 directions
        boolean found = dfs(board, word, i + 1, j, idx + 1) ||
                        dfs(board, word, i - 1, j, idx + 1) ||
                        dfs(board, word, i, j + 1, idx + 1) ||
                        dfs(board, word, i, j - 1, idx + 1);

        // backtrack
        board[i][j] = temp;

        return found;
    }
}
