class Node {
    int first,second,third;
    public Node(int i,int j,int k){
        this.first = i;
        this.second = j;
        this.third = k;
    }
}
class Solution {
    int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.first));
        int[][] visited = new int[n][m];
       for (int[] row : visited) {
    Arrays.fill(row, Integer.MAX_VALUE);
}
        visited[0][0] = 0;
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){

            Node temp = pq.poll();
            int currdiff = temp.first;
            int ci = temp.second;
            int cj = temp.third;

            for(int[] dir : directions){
                int ni = ci + dir[0];
                int nj = cj + dir[1];
                
                if(ni >= 0 && ni < n && nj >= 0 && nj < m){

                    int diff = Math.abs(heights[ci][cj] - heights[ni][nj]);
                    int maxdiff = Math.max(currdiff,diff);
                    if(maxdiff < visited[ni][nj]){
                       visited[ni][nj] = maxdiff;
                    pq.add(new Node(maxdiff,ni,nj));
                    }
                    
                }
            }
        }
        return visited[n - 1][m - 1];
    }
}