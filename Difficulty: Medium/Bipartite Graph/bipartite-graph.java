//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while (T-- > 0) {
            String[] S = br.readLine().trim().split(" ");
            int V = Integer.parseInt(S[0]);
            S = br.readLine().trim().split(" ");
            int E = Integer.parseInt(S[0]);
            ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
            for (int i = 0; i < V; i++) {
                adj.add(new ArrayList<Integer>());
            }
            for (int i = 0; i < E; i++) {
                String[] s = br.readLine().trim().split(" ");
                int u = Integer.parseInt(s[0]);
                int v = Integer.parseInt(s[1]);
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            Solution obj = new Solution();
            boolean ans = obj.isBipartite(adj);
            if (ans)
                System.out.println("true");
            else
                System.out.println("false");

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    private boolean checkDFS(int[] color,ArrayList<ArrayList<Integer>> adj,int curr,int currColor){
        color[curr] = currColor;
        
        for(int v : adj.get(curr)){
            if(color[curr] == color[v]){
                return false;
            }
            if(color[v] == -1){
               int colorofv = 1 - currColor;
                if(checkDFS(color,adj,v,colorofv) == false){
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(ArrayList<ArrayList<Integer>> adj) {
        int[] color = new int[adj.size()];
        Arrays.fill(color,-1);
        int n = adj.size();
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
              if(checkDFS(color,adj,i,1) == false){
                  return false;
              }
            }
        }
        return true;
    }
}