import java.util.*;

class Solution {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        
        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            graph.computeIfAbsent(u, x -> new HashMap<>()).put(v, cnt);
            graph.computeIfAbsent(v, x -> new HashMap<>()).put(u, cnt);
        }

        // Max Heap based on remaining moves
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        pq.offer(new int[]{0, maxMoves});
        
        Map<Integer, Integer> seen = new HashMap<>();
        Map<String, Integer> usedEdges = new HashMap<>();

        while (!pq.isEmpty()) {
            int[] top = pq.poll();
            int node = top[0], movesLeft = top[1];

            if (seen.containsKey(node)) continue;
            seen.put(node, movesLeft);

            if (!graph.containsKey(node)) continue;

            for (int nei : graph.get(node).keySet()) {
                int cnt = graph.get(node).get(nei);
                int used = Math.min(cnt, movesLeft);

                String key = node + "," + nei;
                usedEdges.put(key, used);

                int movesToNeighbor = movesLeft - cnt - 1;
                if (!seen.containsKey(nei) && movesToNeighbor >= 0) {
                    pq.offer(new int[]{nei, movesToNeighbor});
                }
            }
        }

        int result = seen.size(); // reachable original nodes

        for (int[] edge : edges) {
            int u = edge[0], v = edge[1], cnt = edge[2];
            int usedFromU = usedEdges.getOrDefault(u + "," + v, 0);
            int usedFromV = usedEdges.getOrDefault(v + "," + u, 0);
            result += Math.min(cnt, usedFromU + usedFromV);
        }

        return result;
    }
}
