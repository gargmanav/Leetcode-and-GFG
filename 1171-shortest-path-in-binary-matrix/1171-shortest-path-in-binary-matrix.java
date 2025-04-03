class Node{
    int first,second,third;
    public Node(int w,int i,int j){
        this.first = w;
        this.second = i;
        this.third = j;
    }
}
class Solution {
    int[][] direction = {{0,-1},{0,1},{-1,0},{1,0},{1,1},{-1,-1},{1,-1},{-1,1}};

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
         if (grid[0][0] == 1 || grid[n-1][m-1] == 1) {
            return -1;
        }
        Queue<Node> que = new LinkedList<>();
        int[][] visited = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                visited[i][j] = Integer.MAX_VALUE;
            }
        }
        visited[0][0] = 0;
        que.add(new Node(0,0,0));
        while(!que.isEmpty()){
            Node temp = que.poll();
            int first = temp.first;
            int second = temp.second;
            int third = temp.third;

            for(int[] dir : direction){
                int nR = second + dir[0];
                int nC = third + dir[1];
                int w = 1;
                if(nR >= 0 && nR < n && nC >= 0 && nC < m && grid[nR][nC] == 0 && first + w < visited[nR][nC]){
                    que.add(new Node(w+first,nR,nC));
                    // grid[nR][nC] = 1;
                    visited[nR][nC] = first+w;
                }
            }
        }
        if(visited[n-1][m-1] == Integer.MAX_VALUE){
            return -1;
        }
        return visited[n-1][m - 1] + 1;
    }
}