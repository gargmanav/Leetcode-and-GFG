class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n + 1;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : dislikes){
            adj.get(arr[0]).add(arr[1]);
            adj.get(arr[1]).add(arr[0]);
        }
        int[] color = new int[n + 1];
        Arrays.fill(color,-1);

        
        for(int i = 1;i <= n;i++){
            Queue<Integer> que = new LinkedList<>();
            if(color[i] == -1){
                que.add(i);
        color[i] = 0;
        while(!que.isEmpty()){
            int U = que.poll();
            for(int V : adj.get(U)){
                if(color[U] == color[V])return false;
                if(color[V] == -1){
                    que.add(V);
                    color[V] = 1 - color[U];
                }
            }
        }
        }
            }
      return true;
    }
}