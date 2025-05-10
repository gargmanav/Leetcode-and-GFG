class Solution {
    public int countPaths(int n, int[][] roads) {
        // Build adjacency list representation of the graph
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        
        for (int[] road : roads) {
            int u = road[0];
            int v = road[1];
            int time = road[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }
        
        // Dijkstra's algorithm to find the shortest paths
        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);
        dist[0] = 0;
        
        // Count of ways to reach each node with the shortest distance
        long[] ways = new long[n];
        ways[0] = 1;
        
        // Priority queue for Dijkstra's algorithm
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[1], b[1]));
        pq.offer(new long[]{0, 0}); // [node, distance]
        
        // Modulo constant
        final int MOD = 1_000_000_007;
        
        while (!pq.isEmpty()) {
            long[] curr = pq.poll();
            int node = (int) curr[0];
            long distance = curr[1];
            
            // Skip if we already found a shorter path
            if (distance > dist[node]) continue;
            
            // Explore neighbors
            for (int[] neighbor : graph.get(node)) {
                int nextNode = neighbor[0];
                long nextDist = distance + neighbor[1];
                
                // If we found a shorter path
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    ways[nextNode] = ways[node];
                    pq.offer(new long[]{nextNode, nextDist});
                } 
                // If we found an equal length path
                else if (nextDist == dist[nextNode]) {
                    ways[nextNode] = (ways[nextNode] + ways[node]) % MOD;
                }
            }
        }
        
        return (int) ways[n - 1];
    }
}