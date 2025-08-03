class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        int n = 26;
        long[][] dist = new long[n][n];
        long INF = (long) 1e18;

        // Step 1: Initialize distances
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0;
        }

        // Step 2: Add the given conversions
        for (int i = 0; i < original.length; i++) {
            int u = original[i] - 'a';
            int v = changed[i] - 'a';
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        // Step 3: Floyd-Warshall to compute all-pairs shortest path
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                    }
                }
            }
        }

        // Step 4: Calculate total minimum cost
        if (source.length() != target.length()) return -1;
        long totalCost = 0;

        for (int i = 0; i < source.length(); i++) {
            char s = source.charAt(i);
            char t = target.charAt(i);

            if (s == t) continue;

            int from = s - 'a';
            int to = t - 'a';

            if (dist[from][to] == INF) return -1;
            totalCost += dist[from][to];
        }

        return totalCost;
    }
}
