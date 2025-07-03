import java.util.*;

class Solution {
    public int minCost(int maxTime, int[][] edges, int[] passingFees) {
        int n = passingFees.length;
        
        // Graph banate hai: u -> (v, time)
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++) graph.add(new ArrayList<>());

        for(int[] edge : edges) {
            int u = edge[0], v = edge[1], time = edge[2];
            graph.get(u).add(new int[]{v, time});
            graph.get(v).add(new int[]{u, time});
        }

        // minFee[node][time] = minimum fee to reach `node` in `time`
        int[][] minFee = new int[n][maxTime + 1];
        for (int[] row : minFee)
            Arrays.fill(row, Integer.MAX_VALUE);

        // PriorityQueue -> [totalFee, timeSpent, node]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{passingFees[0], 0, 0}); // start from node 0
        minFee[0][0] = passingFees[0];

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int fee = cur[0], time = cur[1], node = cur[2];

            // Agar destination pahuch gaye
            if (node == n - 1) return fee;

            for (int[] nei : graph.get(node)) {
                int next = nei[0], t = nei[1];
                int newTime = time + t;

                if (newTime > maxTime) continue;

                int newFee = fee + passingFees[next];
                if (newFee < minFee[next][newTime]) {
                    minFee[next][newTime] = newFee;
                    pq.offer(new int[]{newFee, newTime, next});
                }
            }
        }

        return -1;
    }
}
