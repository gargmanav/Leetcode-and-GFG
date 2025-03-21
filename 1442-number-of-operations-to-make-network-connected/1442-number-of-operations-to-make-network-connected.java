class Solution {
    public int find(int x,int[] parent){
       if(x == parent[x]){
        return x;
       }
       return parent[x] = find(parent[x],parent);
    }
    public void union(int x ,int y,int[] parent){
          int x_parent = find(x,parent);
          int y_parent = find(y,parent);

          if(x_parent == y_parent)return;

          parent[x_parent] = y_parent;
    }
    public int makeConnected(int n, int[][] connections) {
        if(n - 1 > connections.length)return -1;
        int[] parent = new int[n];
        int[] rank = new int[n];
        Arrays.fill(rank,0);
        
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        int components = n;
        for(int[] v : connections){
            if(find(v[0],parent) != find(v[1],parent)){
                union(v[0],v[1],parent);
                components--;
            }
        }
        return components - 1;
    }
}