import java.util.*;

class Solution {
    class Pair {
        String V;
        double value;

        Pair(String V, double value) {
            this.V = V;
            this.value = value;
        }
    }

    private void dfs(Map<String, List<Pair>> adj,
                     String src, String dst,
                     Set<String> visited,
                     double product,
                     double[] result) {

        if (visited.contains(src)) return;
        visited.add(src);

        if (src.equals(dst)) {
            result[0] = product;
            return;
        }

        for (Pair e : adj.getOrDefault(src, new ArrayList<>())) {
            dfs(adj, e.V, dst, visited, product * e.value, result);
            if (result[0] != -1.0) return; // early return if answer found
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = values.length;
        Map<String, List<Pair>> adj = new HashMap<>();

        // ✅ Build adjacency list properly
        for (int i = 0; i < n; i++) {
            String U = equations.get(i).get(0);
            String V = equations.get(i).get(1);
            double value = values[i];

            adj.computeIfAbsent(U, k -> new ArrayList<>()).add(new Pair(V, value));
            adj.computeIfAbsent(V, k -> new ArrayList<>()).add(new Pair(U, 1.0 / value));
        }

        int q = queries.size();
        double[] answer = new double[q];

        for (int i = 0; i < q; i++) {
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            double[] result = new double[] { -1.0 }; // wrapper for mutable result
            if (adj.containsKey(u) && adj.containsKey(v)) {
                Set<String> visited = new HashSet<>();
                dfs(adj, u, v, visited, 1.0, result);
            }

            answer[i] = result[0];
        }

        return answer;
    }
}
