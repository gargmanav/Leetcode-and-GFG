//{ Driver Code Starts
import java.util.*;

// Driver code
class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testcases = sc.nextInt(); // Taking number of test cases as input

        while (testcases-- > 0) {
            int V = sc.nextInt(); // Number of vertices
            int E = sc.nextInt(); // Number of edges

            // Initialize adjacency list
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<>()); // Create a new list for each vertex
            }

            // Add edges to the adjacency list
            for (int i = 0; i < E; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v); // Adding edge u -> v
                adj.get(v).add(u); // Adding edge v -> u (undirected graph)
            }

            // Create Solution object and call bfsOfGraph
            Solution obj = new Solution();
            ArrayList<Integer> result = obj.bfsOfGraph(V, adj);

            // Print the result
            for (int node : result) {
                System.out.print(node + " ");
            }
            System.out.println();
        }

        sc.close(); // Close the scanner
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    public void bfs(Map<Integer, ArrayList<Integer>> adjMap, boolean[] vis, ArrayList<Integer> res, int u) {
        Queue<Integer> que = new LinkedList<>();
        que.add(u);
        vis[u] = true;
        res.add(u);

        while (!que.isEmpty()) {
            int node = que.poll(); // Fix: poll() instead of poll
            if (!adjMap.containsKey(node)) continue;

            for (int v : adjMap.get(node)) {
                if (!vis[v]) {
                    que.add(v); // Fix: Use add() instead of push()
                    vis[v] = true;
                    res.add(v);
                }
            }
        }
    }

    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        Map<Integer, ArrayList<Integer>> adjMap = new HashMap<>();

        for (int i = 0; i < V; i++) {
            adjMap.put(i, new ArrayList<>(adj.get(i))); // Fix: Properly initialize adjacency map
        }

        boolean[] vis = new boolean[V]; // Fix: Correct boolean array initialization
        ArrayList<Integer> res = new ArrayList<>();

        bfs(adjMap, vis, res, 0); // Start BFS from node 0
        return res;
    }
}