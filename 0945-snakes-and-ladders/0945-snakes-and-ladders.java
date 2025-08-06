class Solution {
    public int[] getPos(int val, int n, int[][] board) {
        int quot = (val - 1) / n;
        int rem = (val - 1) % n;
        int row = n - 1 - quot;
        int col = (quot % 2 == 0) ? rem : (n - 1 - rem);
        return new int[]{row, col};
    }
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Queue<Integer> que = new LinkedList<>();
        que.add(1);
        boolean[] visited = new boolean[n * n + 1];
        visited[1] = true;
        int moves = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                int curr = que.poll();
                if (curr == n * n) return moves;
                for (int d = 1; d <= 6; d++) {
                    int nextNum = curr + d;
                    if (nextNum > n * n) continue;
                    int[] pos = getPos(nextNum, n, board);
                    if (board[pos[0]][pos[1]] != -1) {
                        nextNum = board[pos[0]][pos[1]];
                    }
                    if (!visited[nextNum]) {
                        que.add(nextNum);
                        visited[nextNum] = true;
                    }
                }
            }
            moves++;
        }
        return -1;
    }
}