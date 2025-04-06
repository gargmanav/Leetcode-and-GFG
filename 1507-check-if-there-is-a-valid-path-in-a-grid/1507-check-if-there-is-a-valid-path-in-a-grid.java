class Solution {
    private static final int[][][] DIRS = {
        {}, // 0 - dummy
        {{0, -1}, {0, 1}},     // type 1
        {{-1, 0}, {1, 0}},     // type 2
        {{0, -1}, {1, 0}},     // type 3
        {{0, 1}, {1, 0}},      // type 4
        {{0, -1}, {-1, 0}},    // type 5
        {{0, 1}, {-1, 0}}      // type 6
    };
    public boolean hasValidPath(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> que = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        que.add(new int[]{0,0});
        visited[0][0] = true;
        
        while(!que.isEmpty()){
            int[] temp = que.poll();
            int i = temp[0],j = temp[1];
            if (i == n - 1 && j == m - 1) return true;
            int currtype = grid[i][j];

            for(int[] dir : DIRS[currtype]){
                int ni = dir[0] + i;
                int nj = dir[1] + j;

                if(ni >= 0 && ni < n && nj >= 0 && nj < m && !visited[ni][nj]){
                    int nextype = grid[ni][nj];
                    for(int[] arr : DIRS[nextype]){
                        if(i == ni + arr[0] && j == nj + arr[1]){
                            visited[ni][nj] = true;
                            que.add(new int[]{ni,nj});
                        }
                    }
                }
            }

        }
        return false;
    }
}