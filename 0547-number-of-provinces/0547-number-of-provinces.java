class Solution {
    public static void dfs(HashMap<Integer,ArrayList<Integer>> adjMap,int u,boolean[] vis){
          vis[u] = true;
          for(int v : adjMap.get(u)){
            if(vis[v] == false){
                dfs(adjMap,v,vis);
            }
          }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        HashMap<Integer,ArrayList<Integer>> adjMap = new HashMap<>();
        
        for(int i = 0;i<n;i++){
            adjMap.put(i,new ArrayList<>());
            for(int j = 0;j<n;j++){
                if(isConnected[i][j] == 1 && i != j){
                    adjMap.get(i).add(j);
                }
            }
        }

        boolean[] vis = new boolean[n];
        int provinceCount = 0;
        for(int i = 0;i<n;i++){
            if(vis[i] == false){
                provinceCount++;
                dfs(adjMap,i,vis);
            }
        }
        return provinceCount;
    }
}