class Solution {
    private void dfs(int curr,int[][] isConnected,boolean[] visited){
       if(visited[curr]){
        return;
       }
       visited[curr] = true;
       for(int i = 0;i<isConnected[curr].length;i++){
          if(isConnected[curr][i] == 1 && !visited[i]){
            dfs(i,isConnected,visited);
          }
       }
    }
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        for(int i = 0;i<n;i++){
            if(!visited[i]){
                dfs(i,isConnected,visited);
                count++;
            }
        }
        return count;
    }
}