class Solution {
    private boolean dfs(List<List<Integer>> adj,boolean[] visited,int U,int parent){
        visited[U] = true;
        for(int v : adj.get(U)){
            if(parent == v)continue;
            if(visited[v]){
                return true;
            }
            if(dfs(adj,visited,v,U) == true){
                return true;
            }
        }
        return false;
    }
    public boolean isCycle(int V, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<V;i++)adj.add(new ArrayList<>());
        for(int[] arr : edges){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited = new boolean[V];
        boolean ans = false;
        for(int i = 0;i<V;i++){
            if(!visited[i]){
                if(dfs(adj,visited,i,-1) == true){
                    ans = true;
                }
            }
        }
        return ans;
    }
}