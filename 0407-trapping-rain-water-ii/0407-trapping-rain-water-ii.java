class Solution {
    class Pair{
        int row,col,height;
        Pair(int i,int j,int h){
            this.row = i;
            this.col = j;
            this.height = h;
        }
    }
    private int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
    public int trapRainWater(int[][] heightMap) {
        int m = heightMap.length;
        int n = heightMap[0].length;
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.height - b.height);
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < n;i++){
            pq.add(new Pair(0,i,heightMap[0][i]));
            pq.add(new Pair(m - 1,i,heightMap[m - 1][i]));
            visited[0][i] = true;
            visited[m - 1][i] = true;
        }
        for(int j = 0;j < m;j++){
           pq.add(new Pair(j,0,heightMap[j][0]));
           pq.add(new Pair(j,n - 1,heightMap[j][n - 1]));
           visited[j][0] = true;
           visited[j][n - 1] = true;
        }
        int trappedWater = 0;

        while(!pq.isEmpty()){
            Pair curr = pq.poll();
            for(int[] dir : directions){
    int ni = curr.row + dir[0];
    int nj = curr.col + dir[1];
    if(ni >= 0 && ni < m && nj >= 0 && nj < n && !visited[ni][nj]){
        trappedWater += Math.max(0, curr.height - heightMap[ni][nj]);
        pq.add(new Pair(ni, nj, Math.max(curr.height, heightMap[ni][nj])));
        visited[ni][nj] = true;
    }
}
        }
        return trappedWater;
    }
}