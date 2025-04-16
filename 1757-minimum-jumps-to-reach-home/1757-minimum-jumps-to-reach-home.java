class Solution {
    private int dfs(int pos, int target, int a, int b, boolean backJump, int jumps,
                    Set<Integer> forbidden, Set<String> visited, int upperBound) {
        
        // Base cases
        if (pos == target) return jumps;
        if (pos < 0 || pos > upperBound || forbidden.contains(pos)) return -1;

        String key = pos + "," + backJump;
        if (visited.contains(key)) return -1;
        visited.add(key);

        // Forward jump
        int forward = dfs(pos + a, target, a, b, false, jumps + 1, forbidden, visited, upperBound);

        // Backward jump (only if last jump wasn't backward)
        int backward = -1;
        if (!backJump) {
            backward = dfs(pos - b, target, a, b, true, jumps + 1, forbidden, visited, upperBound);
        }

        // Pick valid minimum
        if (forward == -1) return backward;
        if (backward == -1) return forward;
        return Math.min(forward, backward);
    }
    public int minimumJumps(int[] forbidden, int a, int b, int x) {
        Set<Integer> forbiddenSet = new HashSet<>();
        for (int pos : forbidden) {
            forbiddenSet.add(pos);
        }

        int upperBound = 6000; // upper bound to prevent infinite recursion
        return dfs(0, x, a, b, false, 0, forbiddenSet, new HashSet<>(), upperBound);
    }
}