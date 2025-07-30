class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> graph = new ArrayList<>();
        List<Set<Integer>> ancestors = new ArrayList<>();
        int[] inDegree = new int[n];

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
            ancestors.add(new TreeSet<>()); // TreeSet to maintain sorted order
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            inDegree[edge[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();

        // Start with nodes having no incoming edges
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();

            for (int neighbor : graph.get(node)) {
                // Add current node and its ancestors to the neighbor's ancestor list
                ancestors.get(neighbor).add(node);
                ancestors.get(neighbor).addAll(ancestors.get(node));

                // Decrease in-degree and push to queue if it's 0
                if (--inDegree[neighbor] == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // Convert to List<List<Integer>>
        List<List<Integer>> result = new ArrayList<>();
        for (Set<Integer> set : ancestors) {
            result.add(new ArrayList<>(set));
        }

        return result;
    }
}
