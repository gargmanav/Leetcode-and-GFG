class Solution {
    public void dfs(List<List<Integer>> rooms,boolean[] visited,int index){
        if(visited[index] == true)return;
       visited[index] = true;
       for(int arr : rooms.get(index)){
        //  for(int i : arr){
            dfs(rooms,visited,arr);
        //  }
       }
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int n = rooms.size();
        boolean[] visited = new boolean[n];
        dfs(rooms,visited,0);
        int count = 0;
        for(int i = 0;i<n;i++){
            if(visited[i] == true){
               count++;
            }
        }
        return count==n;
    }
}