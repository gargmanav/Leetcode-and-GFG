// User function Template for Java

class Solution {
    public int[] bellmanFord(int Ve, int[][] edges, int src) {
        // code here
         int[] dist = new int[Ve];
         int value = (int) Math.pow(10,8);
         Arrays.fill(dist,value);
         
         dist[src] = 0;
         
         for(int i = 1;i<Ve - 1;i++){
             for(int[] edge : edges){
                 int U = edge[0];
                 int V = edge[1];
                 int W = edge[2];
                 if(dist[U] != value && dist[U] + W < dist[V]){
                     dist[V] = dist[U] + W;
                 }
             }
             
             
         }
         // for cycle detection
             for(int[] edge : edges){
                 int U = edge[0];
                 int V = edge[1];
                 int W = edge[2];
                 if(dist[U] != value && dist[U] + W < dist[V]){
                     return new int[]{-1};
                 }
             }
         return dist;
    }
}
