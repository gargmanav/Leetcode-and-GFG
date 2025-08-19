class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i < numCourses;i++)adj.add(new ArrayList<>());
        int[] indegree = new int[numCourses];
        Arrays.fill(indegree,0);
        for(int[] arr : prerequisites){
           adj.get(arr[1]).add(arr[0]);
           indegree[arr[0]]++;
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<numCourses;i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!que.isEmpty()){
            int curr = que.poll();
            ans.add(curr);
            for(int v : adj.get(curr)){
                indegree[v]--;
                if(indegree[v] == 0){
                    que.add(v);
                }
            }
        }
        return ans.size() == numCourses;
    }
}