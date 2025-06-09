class Solution {
    public void dfs(int node, List<List<Integer>> adj, boolean[] visited, List<Integer> component) {
        visited[node] = true;
        component.add(node);
        for (int neighbor : adj.get(node)) {
            if (!visited[neighbor]) {
                dfs(neighbor, adj, visited, component);
            }
        }
    }

    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        int completeCount = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                List<Integer> component = new ArrayList<>();
                dfs(i, adj, visited, component);

                int nodes = component.size();
                int totalEdges = 0;

                // Count edges inside this component
                for (int node : component) {
                    totalEdges += adj.get(node).size();
                }

                totalEdges /= 2; // Each edge counted twice in undirected graph

                if (totalEdges == nodes * (nodes - 1) / 2) {
                    completeCount++;
                }
            }
        }

        return completeCount;
    }
}
