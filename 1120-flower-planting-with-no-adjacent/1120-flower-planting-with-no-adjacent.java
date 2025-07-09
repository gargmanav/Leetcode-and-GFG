class Solution {
    public int[] gardenNoAdj(int n, int[][] paths) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
           adj.add(new ArrayList<>());
        }
        for(int[] arr : paths){
            adj.get(arr[0] - 1).add(arr[1] - 1);
            adj.get(arr[1] - 1).add(arr[0] - 1);
        }
        int[] color = new int[n];
        Arrays.fill(color,0);
        for(int i = 0;i<n;i++){
            if(color[i] == 0){
                color[i] = 1;
                Queue<Integer> que = new LinkedList<>();
                que.add(i);
                while(!que.isEmpty()){
                    int U = que.poll();
                    for(int V : adj.get(U)){
                        if(color[V] == 0 || color[V] == color[U]){
                            color[V] = color[U] + 1;
                            que.add(V);
                        }
                        if(color[V] > 4)color[V] %= 4;
                    }
                }
            }
        }
        return color;
    }
}