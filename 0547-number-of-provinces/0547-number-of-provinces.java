class Solution {
    private void dfs(List<List<Integer>> adj,boolean[] visited,int currNode){
        visited[currNode] = true;
        for(int num : adj.get(currNode)){
            if(visited[num] == false){
               dfs(adj,visited,num);
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++){
            adj.add(new ArrayList<>());
            for(int j = 0;j < isConnected[i].length;j++){
                if(i != j && isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0;i < n;i++){
            if(visited[i] == false){
                dfs(adj,visited,i);
                count++;
            }
        }
        return count;
    }
}