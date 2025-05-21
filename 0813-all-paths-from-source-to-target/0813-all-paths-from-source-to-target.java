class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        int target = graph.length - 1;
        Queue<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        
        // Start from node 0
        queue.add(new ArrayList<>(Arrays.asList(0)));
        
        while (!queue.isEmpty()) {
            List<Integer> path = queue.poll();
            int lastNode = path.get(path.size() - 1);
            
            // If path reaches the target, add to result
            if (lastNode == target) {
                result.add(new ArrayList<>(path));
                continue;
            }
            
            // Explore neighbors
            for (int neighbor : graph[lastNode]) {
                List<Integer> newPath = new ArrayList<>(path);
                newPath.add(neighbor);
                queue.add(newPath);
            }
        }
        return result;
    }
}