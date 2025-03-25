class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // Step 1: Build the adjacency list representation of the graph
        List<int[]>[] graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int from = edge[0], to = edge[1], weight = edge[2];
            graph[from].add(new int[]{to, weight});
            graph[to].add(new int[]{from, weight});
        }

        int minReachable = n;
        int resultCity = -1;

        // Step 2: Apply Dijkstra's algorithm for each city
        for (int i = 0; i < n; i++) {
            int reachableCount = dijkstra(n, graph, i, distanceThreshold);
            // Step 3: Update the result based on the number of reachable cities
            if (reachableCount < minReachable || (reachableCount == minReachable && i > resultCity)) {
                minReachable = reachableCount;
                resultCity = i;
            }
        }

        return resultCity;
    }

    private int dijkstra(int n, List<int[]>[] graph, int src, int threshold) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        pq.offer(new int[]{src, 0});

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int city = current[0], d = current[1];

            if (d > dist[city]) continue; // Ignore outdated entries

            for (int[] neighbor : graph[city]) {
                int nextCity = neighbor[0], weight = neighbor[1];
                if (dist[nextCity] > d + weight) {
                    dist[nextCity] = d + weight;
                    pq.offer(new int[]{nextCity, dist[nextCity]});
                }
            }
        }

        // Count reachable cities within threshold
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (i != src && dist[i] <= threshold) count++;
        }

        return count;
    }
}