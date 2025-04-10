class Solution {
    private void dfs(ArrayList<ArrayList<Integer>> adj,boolean[] visited,int index){
      visited[index] = true;

      for(int v : adj.get(index)){
        if(visited[v] == false){
            dfs(adj,visited,v);
        }
      }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
    ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
    
    for (int i = 0; i < n; i++) {
        adj.add(new ArrayList<>());
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && i != j) {
                adj.get(i).add(j);
            }
        }
    }
    boolean[] visited = new boolean[adj.size()];
    int count = 0;
    for(int i = 0;i<adj.size();i++){
        if(visited[i] == false){
            dfs(adj,visited,i);
            count++;
        }
    }
    return count;
    }
}