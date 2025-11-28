class Solution {

    int count = 0; // components counter

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {

        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }

        dfs(0, -1, adj, values, k);
        return count;
    }

    private long dfs(int u, int parent, List<List<Integer>> adj, int[] values, int k) {

        long sum = values[u];  // apna value start

        for (int v : adj.get(u)) {
            if (v == parent) continue; // parent skip
            sum += dfs(v, u, adj, values, k); // child se sum lo
        }

        if (sum % k == 0) {
            count++;   // component ban gaya
            return 0;  // parent ko kuch contribute nahi karega
        }

        return sum;  // nahi bana to parent me add hoga
    }
}
