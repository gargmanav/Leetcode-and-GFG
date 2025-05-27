class Solution {
    private int time = 0;
    
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer>[] graph = new ArrayList[n];
        int[] disc = new int[n];
        int[] low = new int[n];
        Arrays.fill(disc, -1); // mark all nodes as unvisited

        // Build the graph
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (List<Integer> conn : connections) {
            int u = conn.get(0), v = conn.get(1);
            graph[u].add(v);
            graph[v].add(u);
        }

        // DFS from node 0
        dfs(0, -1, graph, disc, low, result);
        return result;
    }

    private void dfs(int u, int parent, List<Integer>[] graph, int[] disc, int[] low, List<List<Integer>> result) {
        disc[u] = low[u] = time++;
        
        for (int v : graph[u]) {
            if (v == parent) continue; // skip the edge to parent
            if (disc[v] == -1) { // if v is not visited
                dfs(v, u, graph, disc, low, result);
                low[u] = Math.min(low[u], low[v]);
                if (low[v] > disc[u]) {
                    result.add(Arrays.asList(u, v));
                }
            } else {
                low[u] = Math.min(low[u], disc[v]);
            }
        }
    }
}
