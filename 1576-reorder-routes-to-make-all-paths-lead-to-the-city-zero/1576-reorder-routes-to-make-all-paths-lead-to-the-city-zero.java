class Solution {
    class Pair{
        int padosi,disha;
        Pair(int p,int d){
            this.padosi = p;
            this.disha = d;
        }
    }
    private int count = 0;
    private void dfs(List<List<Pair>> adj, boolean[] visited, int root) {
    visited[root] = true;
    for (Pair pair : adj.get(root)) {
        if (!visited[pair.padosi]) {
            count += pair.disha; // increment if needs reversal
            dfs(adj, visited, pair.padosi);
        }
    }
}
    public int minReorder(int n, int[][] connections) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] arr : connections){
            adj.get(arr[0]).add(new Pair(arr[1], 1));
            adj.get(arr[1]).add(new Pair(arr[0], 0));
        }
        boolean[] visited = new boolean[n];
        dfs(adj,visited,0);
        return count;
    }
}