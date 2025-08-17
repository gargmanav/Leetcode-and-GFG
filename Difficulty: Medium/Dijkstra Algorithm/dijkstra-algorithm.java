import java.util.*;
class Solution {
    public int[] dijkstra(int V, int[][] edges, int src) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < V;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2]});
            adj.get(edge[1]).add(new int[]{edge[0],edge[2]});
        }
        int[] dist = new int[V];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src] = 0;
        
PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(arr -> arr[0]));        
  pq.add(new int[]{0,src});
        
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int W = curr[0],U = curr[1];
            for(int [] v : adj.get(U)){
                if(dist[v[0]] > W + v[1]){
                    dist[v[0]] = W + v[1];
                    pq.add(new int[]{W + v[1],v[0]});
                }
            }
        }
        return dist;
    }
}