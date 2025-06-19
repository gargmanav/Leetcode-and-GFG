class Solution {
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        int n = quiet.length;
        List<List<Integer>> graph = new ArrayList<>();
        int[] answer = new int[n];
        int[] inDegree = new int[n];

        for(int i = 0;i<n;i++){
           graph.add(new ArrayList<>());
           answer[i] = i;
        }

        for(int[] rich : richer){
            graph.get(rich[0]).add(rich[1]);
            inDegree[rich[1]]++;
        }

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i < n;i++){
            if(inDegree[i] ==  0){
                que.add(i);
            }
        }

        while(!que.isEmpty()){
            int u = que.poll();
            for(int v : graph.get(u)){
                if (quiet[answer[u]] < quiet[answer[v]]) {
                    answer[v] = answer[u];
                }
                inDegree[v]--;
                if(inDegree[v] == 0){
                    que.add(v);
                }
            }
        }
        return answer;
    }
}