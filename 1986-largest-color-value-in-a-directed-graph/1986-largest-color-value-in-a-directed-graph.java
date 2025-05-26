class Solution {
    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<List<Integer>> graph = new ArrayList<>();
        int[] indegree = new int[n];

        // Create graph and indegree array
        for (int i = 0; i < n; i++) graph.add(new ArrayList<>());
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            indegree[edge[1]]++;
        }

        // Initialize queue for Kahn's Algorithm (topological sort)
        Queue<Integer> queue = new LinkedList<>();
        int[][] count = new int[n][26];

        // Add nodes with zero indegree
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) queue.offer(i);
            count[i][colors.charAt(i) - 'a'] = 1;
        }

        int visited = 0, maxColorValue = 0;

        // Process nodes in topological order
        while (!queue.isEmpty()) {
            int node = queue.poll();
            visited++;

            for (int neighbor : graph.get(node)) {
                // Update color counts for neighbor
                for (int c = 0; c < 26; c++) {
                    int colorIndex = colors.charAt(neighbor) - 'a';
                    count[neighbor][c] = Math.max(count[neighbor][c],
                                                  count[node][c] + (c == colorIndex ? 1 : 0));
                }

                indegree[neighbor]--;
                if (indegree[neighbor] == 0) queue.offer(neighbor);
            }

            // Update max value
            for (int c = 0; c < 26; c++) {
                maxColorValue = Math.max(maxColorValue, count[node][c]);
            }
        }

        return visited == n ? maxColorValue : -1;
    }
}