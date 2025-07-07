class Solution {
    public static ArrayList<Integer> topoSort(int V, int[][] edges) {
       List<List<Integer>> adj = new ArrayList<>();
       
       for(int i = 0;i < V;i++){
           adj.add(new ArrayList<>());
       }
       for(int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
       }
       
       int[] indegree = new int[V];
       for(int i = 0;i < V;i++){
           for(int v : adj.get(i)){
               indegree[v]++;
           }
       }
       
       Queue<Integer> que = new LinkedList<>();
       for(int i = 0;i < V;i++){
           if(indegree[i] == 0){
               que.add(i);
           }
       }
       
       ArrayList<Integer> result = new ArrayList<>();
       while(!que.isEmpty()){
           int u = que.poll();
           result.add(u);
           for(int v : adj.get(u)){
               indegree[v]--;
               if(indegree[v] == 0){
                   que.add(v);
               }
           }
       }
       return result;
    }
}