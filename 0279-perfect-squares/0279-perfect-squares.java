class Solution {
    public int numSquares(int n) {
         Queue<Integer> queue = new LinkedList<>();
    Set<Integer> visited = new HashSet<>();
    
    queue.add(0);
    visited.add(0);
    int steps = 0;

    while (!queue.isEmpty()) {
        int size = queue.size();
        steps++;
        for (int i = 0; i < size; i++) {
            int curr = queue.poll();
            for (int j = 1; j * j + curr <= n; j++) {
                int next = curr + j * j;
                if (next == n) return steps;
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.add(next);
                }
            }
        }
    }
    return -1;
    }
}