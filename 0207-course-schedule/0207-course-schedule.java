class Solution {
    private boolean dfs(List<List<Integer>> adj,boolean[] visited,boolean[] inRecursion,int curr){
        visited[curr] = true;
        inRecursion[curr] = true;
        for(int v : adj.get(curr)){
            if(visited[v] == false && !dfs(adj,visited,inRecursion,v)){
                return false;
            }else if(inRecursion[v] == true){
                return false;
            }
        }
        inRecursion[curr] = false;
        return true;
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : prerequisites){
            adj.get(arr[1]).add(arr[0]);
        }
        boolean[] visited  = new boolean[numCourses];
        boolean[] inRecusion = new boolean[numCourses];
        for(int i = 0;i < numCourses;i++){
            if(!visited[i] && !dfs(adj,visited,inRecusion,i)){
               return false;
            }
        }
        return true;
    }
}