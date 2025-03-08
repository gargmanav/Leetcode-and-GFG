class Solution {
    private boolean topologicalsort(Map<Integer,ArrayList<Integer>> adj,int[] indegree,int numCourses){
        int count = 0;
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i< numCourses ;i++){
            if(indegree[i] == 0){
                count++;
                que.add(i);
            }
        }
        while(!que.isEmpty()){
            int u = que.poll();
            
            if (adj.containsKey(u)) {
            for(int v : adj.get(u)){
               indegree[v]--;
               if(indegree[v] == 0){
                que.add(v);
                count++;
               }
            }
            }
        }
        return (count == numCourses);
    }
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer,ArrayList<Integer>> adj = new HashMap<>();
        int[] indegree = new int[numCourses];
        
        for(int[] v : prerequisites){
            int a = v[0];
            int b = v[1];

            adj.putIfAbsent(b, new ArrayList<>());
            adj.get(b).add(a);
            indegree[a]++;
        }
        return topologicalsort(adj,indegree,numCourses);
    }
}