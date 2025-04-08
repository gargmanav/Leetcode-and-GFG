class Node {
    int src, price, k;
    Node(int a, int b, int c) {
        this.src = a;
        this.price = b;
        this.k = c;
    }
}

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] flight : flights) {
            map.computeIfAbsent(flight[0], x -> new ArrayList<>())
                .add(new int[]{flight[1], flight[2]});
        }

        // dist[i][j] = min cost to reach city i with j stops
        int[][] dist = new int[n][k + 2];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[src][0] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.price));
        pq.offer(new Node(src, 0, 0)); // (node, cost, stops)

        while (!pq.isEmpty()) {
            Node curr = pq.poll();

            if (curr.src == dst) return curr.price;
            if (curr.k > k) continue; // more than allowed stops

            if (!map.containsKey(curr.src)) continue;

            for (int[] nei : map.get(curr.src)) {
                int nextCity = nei[0], price = nei[1];
                int newCost = curr.price + price;

                // Only consider this path if it's cheaper than what we previously recorded
                if (newCost < dist[nextCity][curr.k + 1]) {
                    dist[nextCity][curr.k + 1] = newCost;
                    pq.offer(new Node(nextCity, newCost, curr.k + 1));
                }
            }
        }

        return -1;
    }
}