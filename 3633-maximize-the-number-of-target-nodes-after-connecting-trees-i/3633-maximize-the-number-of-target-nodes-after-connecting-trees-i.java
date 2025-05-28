class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length + 1; // Number of nodes in the first tree
        int m = edges2.length + 1; // Number of nodes in the second tree

        // Build adjacency lists for both trees
        List<Integer>[] tree1 = buildGraph(edges1, n);
        List<Integer>[] tree2 = buildGraph(edges2, m);

        // Precompute the maximum number of reachable nodes in tree2 within k-1 distance
        int maxReachableInTree2 = 0;
        if (k > 0) {
            for (int i = 0; i < m; i++) {
                maxReachableInTree2 = Math.max(maxReachableInTree2, bfs(tree2, i, k - 1));
            }
        }

        int[] result = new int[n];

        // For each node in tree1, compute the maximum number of target nodes
        for (int i = 0; i < n; i++) {
            int reachableInTree1 = bfs(tree1, i, k);
            result[i] = reachableInTree1 + maxReachableInTree2;
        }

        return result;
    }

    // Helper method to build the adjacency list representation of a tree
    private List<Integer>[] buildGraph(int[][] edges, int n) {
        List<Integer>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }
        return graph;
    }

    // Helper method to perform BFS and count reachable nodes within a given distance
    private int bfs(List<Integer>[] graph, int start, int maxDist) {
        int count = 0;
        boolean[] visited = new boolean[graph.length];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] nodeInfo = queue.poll();
            int node = nodeInfo[0];
            int dist = nodeInfo[1];

            if (dist > maxDist) continue;
            count++;

            for (int neighbor : graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true;
                    queue.offer(new int[]{neighbor, dist + 1});
                }
            }
        }

        return count;
    }
}