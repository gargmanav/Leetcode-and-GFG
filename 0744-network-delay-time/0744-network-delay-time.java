class Node {
    int vertex, time;
    public Node(int v, int t) {
        this.vertex = v;
        this.time = t;
    }
}
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Node>> adj = new ArrayList<>();
        for(int i = 0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] arr : times){
            int u = arr[0];
            int v = arr[1];
            int w = arr[2];
            adj.get(u).add(new Node(v,w));
        }
        int[] dist = new int[n + 1];
        Arrays.fill(dist,Integer.MAX_VALUE);
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> a.time - b.time);
        pq.add(new Node(k,0));
        dist[k] = 0;

        while(!pq.isEmpty()){
            Node curr = pq.poll();
            int u = curr.vertex;
            int w = curr.time;
            for(Node temp : adj.get(u)){
                int v = temp.vertex;
                int t = temp.time;
                if(dist[v] > w + t){
                    dist[v] = w + t;
                    pq.add(new Node(v,w+t));
                }
            }
        }
        int max = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE) return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}