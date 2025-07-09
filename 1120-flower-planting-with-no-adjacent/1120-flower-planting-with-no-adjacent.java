class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the graph
        for (int[] path : paths) {
            int a = path[0] - 1;
            int b = path[1] - 1;
            adj[a].add(b);
            adj[b].add(a);
        }

        int[] res = new int[n]; // stores flower type for each garden

        for (int i = 0; i < n; i++) {
            boolean[] used = new boolean[5]; // flower types 1 to 4

            // mark the flower types used by adjacent gardens
            for (int neighbor : adj[i]) {
                if (res[neighbor] != 0) {
                    used[res[neighbor]] = true;
                }
            }

            // assign the first available flower type
            for (int type = 1; type <= 4; type++) {
                if (!used[type]) {
                    res[i] = type;
                    break;
                }
            }
        }

        return res;
    }
}
