class Solution {
    private boolean checkBFS(int[][] graph,int curr,int[] color,int currColor){
        Queue<Integer> que = new LinkedList<>();
        que.add(curr);
        color[curr] = currColor;
        while(!que.isEmpty()){
            int u = que.poll();
            for(int v : graph[u]){
                if(color[v] == color[u]){
                    return false;
                }else if(color[v] == -1){
                    color[v] = 1 - color[u];
                    que.add(v);
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i = 0;i<n;i++){
            if(color[i] == -1){
                if(checkBFS(graph,i,color,1) == false){
                    return false;
                }
            }

        }
       return true;
    }
}