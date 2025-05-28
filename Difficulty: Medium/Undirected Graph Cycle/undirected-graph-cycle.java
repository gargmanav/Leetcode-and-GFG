class Solution {
    private boolean dfs(int curr,int parent,boolean[] visited,List<List<Integer>> adj){
        visited[curr] = true;
        for (int neighbor : adj.get(curr)) {
            if (!visited[neighbor]) {
                if (dfs(neighbor, curr, visited, adj)) {
                    return true;
                }
            } else if (neighbor != parent) {
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
       List<List<Integer>> adj = new ArrayList<>();
       for(int i = 0;i<V;i++)adj.add(new ArrayList<>());
       for(int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
           adj.get(edge[1]).add(edge[0]);
       }
       boolean[] visited = new boolean[V];
       Arrays.fill(visited,false);
       for(int i=0;i<V;i++){
           if(!visited[i]){
               if(dfs(i,-1,visited,adj)){
                  return true;
               }
           }
       } 
       return false;
    }
}