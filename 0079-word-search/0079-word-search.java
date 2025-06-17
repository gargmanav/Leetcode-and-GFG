class Solution {
    private int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private boolean dfs(int i, int j, String word, int index, char[][] board, boolean[][] visited) {
        if (index == word.length()) return true;
        
        int n = board.length, m = board[0].length;
        
        if (i < 0 || j < 0 || i >= n || j >= m || visited[i][j] || board[i][j] != word.charAt(index)) {
            return false;
        }

        visited[i][j] = true;

        for (int[] dir : directions) {
            int ni = i + dir[0], nj = j + dir[1];
            if (dfs(ni, nj, word, index + 1, board, visited)) {
                return true;
            }
        }

        visited[i][j] = false; // backtrack
        return false;
    }

    public boolean exist(char[][] board, String word) {
        int n = board.length, m = board[0].length;
        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (dfs(i, j, word, 0, board, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }
}