class Solution {
    public int minTime(int n, int[][] edges) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0;i < n;i++)adj.add(new ArrayList<>());
        for(int[] edge : edges){
            adj.get(edge[0]).add(new int[]{edge[1],edge[2],edge[3]});
        }
        int[] dist = new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);
        pq.add(new int[]{0,0});
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int time = curr[1];
            if(time > dist[u])continue;
            for(int[] arr : adj.get(u)){
                int waittime = Math.max(time,arr[1]);
                if(waittime <= arr[2] && dist[arr[0]] > waittime + 1){
                    dist[arr[0]] = waittime + 1;
                    pq.add(new int[]{arr[0],waittime + 1});
                }
            }
        }
        return dist[n - 1] == Integer.MAX_VALUE ? -1 : dist[n - 1];
    }
}