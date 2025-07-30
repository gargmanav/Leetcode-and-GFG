class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        int[] indegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
           adj.get(edge[0]).add(edge[1]);
        }
        for(int i = 0;i<n;i++){
          for(int num : adj.get(i)){
            indegree[num]++;
          }
        }
        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(indegree[i] == 0){
                que.add(i);
            }
        }
        List<Set<Integer>> result = new ArrayList<>();
        for(int i = 0;i<n;i++)result.add(new TreeSet<>());
        while(!que.isEmpty()){
            int u = que.poll();
            for(int v : adj.get(u)){
                result.get(v).add(u);
                result.get(v).addAll(result.get(u));
                indegree[v]--;
                if(indegree[v] == 0)que.add(v);
            }
        }
        List<List<Integer>> output = new ArrayList<>();
        for (Set<Integer> set : result) {
            output.add(new ArrayList<>(set));
        }

        return output;
    }
}