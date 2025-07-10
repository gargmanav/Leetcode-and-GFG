class Solution {
    public int findShortestCycle(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());
        
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        int minCycle = Integer.MAX_VALUE;

        // BFS from each node
        for (int start = 0; start < n; start++) {
            int[] depth = new int[n];
            Arrays.fill(depth, -1);
            Queue<int[]> q = new LinkedList<>(); // int[]{node, parent}
            q.add(new int[]{start, -1});
            depth[start] = 0;

            while (!q.isEmpty()) {
                int[] curr = q.poll();
                int u = curr[0], parent = curr[1];

                for (int v : adj.get(u)) {
                    if (depth[v] == -1) {
                        depth[v] = depth[u] + 1;
                        q.add(new int[]{v, u});
                    } else if (v != parent) {
                        // Cycle found
                        int cycleLen = depth[u] + depth[v] + 1;
                        minCycle = Math.min(minCycle, cycleLen);
                    }
                }
            }
        }

        return minCycle == Integer.MAX_VALUE ? -1 : minCycle;
    }
}
