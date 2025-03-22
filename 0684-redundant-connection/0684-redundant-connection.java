class Solution {
    private int find(int x,int[] parent){
        if(x == parent[x]){
            return x;
        }
       return parent[x] = find(parent[x],parent);
    }
    private void union(int x,int y,int[] parent){
        int x_parent = find(x,parent);
        int y_parent = find(y,parent);

        if(x_parent == y_parent){
            return;
        }
        parent[x_parent] = y_parent;
    }
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];

        for(int i = 1;i<=n;i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];

            if(find(u,parent) == find(v,parent)){
                return edge;
            }
            union(u,v,parent);
        }
      return new int[0];
    }
}