class Solution {
    private static final int MOD = 1_000_000_007;

    public int countRestrictedPaths(int n, int[][] edges) {
        // Step 1: Build graph
        List<int[]>[] graph = new ArrayList[n + 1];
        for (int i = 0; i <= n; i++) graph[i] = new ArrayList<>();
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
            graph[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        // Step 2: Dijkstra from node n
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[n] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{n, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0], d = curr[1];
            if (d > dist[u]) continue;
            for (int[] neighbor : graph[u]) {
                int v = neighbor[0], weight = neighbor[1];
                if (dist[v] > dist[u] + weight) {
                    dist[v] = dist[u] + weight;
                    pq.offer(new int[]{v, dist[v]});
                }
            }
        }

        // Step 3: DFS + Memoization
        Integer[] memo = new Integer[n + 1];
        return dfs(1, n, graph, dist, memo);
    }

    private int dfs(int u, int n, List<int[]>[] graph, int[] dist, Integer[] memo) {
        if (u == n) return 1;
        if (memo[u] != null) return memo[u];

        long res = 0;
        for (int[] neighbor : graph[u]) {
            int v = neighbor[0];
            if (dist[u] > dist[v]) {
                res = (res + dfs(v, n, graph, dist, memo)) % MOD;
            }
        }

        return memo[u] = (int) res;
    }
}
