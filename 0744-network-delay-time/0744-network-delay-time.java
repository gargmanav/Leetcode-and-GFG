class Node {
    int vertex, time;
    public Node(int vertex, int time) {
        this.vertex = vertex;
        this.time = time;
    }
}

class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        // Step 1: Create adjacency list for graph
        List<List<Node>> adj = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            adj.get(u).add(new Node(v, w));
        }

        // Step 2: Min-heap (priority queue) based on time
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.time - b.time);
        pq.offer(new Node(k, 0));

        // Step 3: Distance array to track shortest time to each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;

        // Step 4: Dijkstra's Algorithm
        while (!pq.isEmpty()) {
            Node curr = pq.poll();
            int u = curr.vertex;
            int time = curr.time;

            for (Node neighbor : adj.get(u)) {
                int v = neighbor.vertex;
                int wt = neighbor.time;
                if (dist[v] > time + wt) {
                    dist[v] = time + wt;
                    pq.offer(new Node(v, dist[v]));
                }
            }
        }

        // Step 5: Find max time to reach all nodes
        int maxTime = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1; // unreachable node
            maxTime = Math.max(maxTime, dist[i]);
        }

        return maxTime;
    }
}