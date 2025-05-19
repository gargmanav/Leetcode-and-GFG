//{ Driver Code Starts


import java.io.*;
import java.lang.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static PrintWriter ot;

    public static void main(String args[]) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        ot = new PrintWriter(System.out);
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int V = Integer.parseInt(br.readLine().trim());
            int E = Integer.parseInt(br.readLine().trim());
            List<List<int[]>> list = new ArrayList<>();
            for (int i = 0; i < V; i++) list.add(new ArrayList<>());
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int a = Integer.parseInt(s[0]);
                int b = Integer.parseInt(s[1]);
                int c = Integer.parseInt(s[2]);
                list.get(a).add(new int[] {b, c});
                list.get(b).add(new int[] {a, c});
            }
            ot.println(new Solution().spanningTree(V, E, list));

            ot.println("~");
        }
        ot.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
   static int[] parent;
   static int[] rank;
    static int find(int v){
        if(parent[v] == v){
            return v;
        }
        return parent[v] = find(parent[v]);
    }
    static void union(int u,int v){
        int parentU = find(u);
        int parentV = find(v);

        if (parentU == parentV) return;

        if (rank[parentU] < rank[parentV]) {
            parent[parentU] = parentV;
        } else if (rank[parentU] > rank[parentV]) {
            parent[parentV] = parentU;
        } else {
            parent[parentV] = parentU;
            rank[parentU]++;
        }
    }
    static int kruskal(List<int[]> edges,int V){
        int sum = 0;
        int count = 0;
        for(int[] arr : edges){
            int u = arr[0];
            int v = arr[1];
            
            int parentu = find(u);
            int parentv = find(v);
            
            if(parentu != parentv){
                union(u,v);
                sum += arr[2];
                count++;
                if(count == V - 1)break;
            }
        }
        return sum;
    }
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        List<int[]> edges = new ArrayList<>();
for (int u = 0; u < V; u++) {
    for (int[] neighbor : adj.get(u)) {
        int v = neighbor[0];
        int wt = neighbor[1];
        if (u < v) {
            edges.add(new int[]{u, v, wt});  // ✅ Must be length 3
        }
    }
}
        parent = new int[V];
        rank = new int[V];
        for(int i = 0;i<V;i++){
            parent[i] = i;
            rank[i] = 0;
        }
        edges.sort((a,b)->a[2] - b[2]);
        return kruskal(edges,V);
    }
}