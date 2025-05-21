class Solution {
    int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();
        Queue<int[]> que = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int[] arr : visited){
            Arrays.fill(arr,-1);
        }
        int remaininghealth = health - grid.get(0).get(0);
        if(remaininghealth <= 0)return false;
        que.add(new int[]{0,0,remaininghealth});
        visited[0][0] = 1;

        while(!que.isEmpty()){
            int[] temp = que.poll();
            int i = temp[0],j = temp[1],h = temp[2];
            if(i == n - 1 && j == m - 1 && h >= 1) return true;
            for(int[] dir : directions){
                int ni = i + dir[0];
                int nj = j + dir[1];
                if(ni < 0 || nj < 0 || ni >= n || nj >= m )continue;

                int cost = grid.get(ni).get(nj);
                int remain = h - cost;
                if(remain > 0 && visited[ni][nj] < remain){
                    visited[ni][nj] = remain;
                    que.add(new int[]{ni,nj,remain});
                }
            }
        }
        return false;
    }
}