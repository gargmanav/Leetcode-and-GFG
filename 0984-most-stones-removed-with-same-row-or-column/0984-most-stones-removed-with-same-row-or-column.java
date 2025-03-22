class Solution {
    private void dfs(int[][] stones,boolean[] visited,int index){
        visited[index] = true;
        for(int i = 0;i<stones.length;i++){
            int r = stones[index][0];
            int c = stones[index][1];
            if(visited[i] == false && (stones[i][0] == r || stones[i][1] == c)){
                dfs(stones,visited,i);
            }
        }
    }
    public int removeStones(int[][] stones) {
        int n = stones.length;
        int group = 0;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(visited[i] == true)continue;
            dfs(stones,visited,i);
                group++;
        }
        return n-group;
    }
}