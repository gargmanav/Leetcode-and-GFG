class Solution {
    public boolean canMeasureWater(int x, int y, int target) {
        Queue<int[]> que = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        que.add(new int[]{0, 0});
        visited.add("0,0");

        while (!que.isEmpty()) {
            int[] temp = que.poll();
            int a = temp[0], b = temp[1];

            if (a == target || b == target || a + b == target) return true;

            List<int[]> nextStates = Arrays.asList(
                new int[]{x, b},        // Fill jug1
                new int[]{a, y},        // Fill jug2
                new int[]{0, b},        // Empty jug1
                new int[]{a, 0},        // Empty jug2
                new int[]{a - Math.min(a, y - b), b + Math.min(a, y - b)},  // Pour jug1 -> jug2
                new int[]{a + Math.min(b, x - a), b - Math.min(b, x - a)}   // Pour jug2 -> jug1
            );

            for (int[] state : nextStates) {
                String key = state[0] + "," + state[1];
                if (!visited.contains(key)) {
                    visited.add(key);
                    que.add(state);
                }
            }
        }
        return false;
    }
}