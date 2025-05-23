class Solution {
    private boolean dfs(List<List<Integer>> adj, int source, int destination,boolean[] visited){
        if(source == destination)return true;
        visited[source] = true;
        for(Integer num : adj.get(source)){
            if(!visited[num] && dfs(adj,num,destination,visited)){
                return true;
            }
        }
        return false;
    }
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        boolean[] visited = new boolean[n];
        return dfs(adj,source,destination,visited);
    }
}