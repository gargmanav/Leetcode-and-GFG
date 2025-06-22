class Solution {
    class Pair{
        int i,j;
        Pair(int row,int col){
           this.i = row;
           this.j = col;
        }
    }
    private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
    public int nearestExit(char[][] maze, int[] entrance) {
        int n = maze.length;
        int m = maze[0].length;
        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(entrance[0],entrance[1]));
        maze[entrance[0]][entrance[1]] = '+';
        int steps = 0;
        while(!que.isEmpty()){
            int N = que.size();
            while(N-- > 0){
               Pair curr = que.poll();
               int row = curr.i;
               int col = curr.j;
               if((row != entrance[0] || col != entrance[1]) &&
                    (row == 0 || row == n - 1 || col == 0 || col == m - 1)){
                return steps;
               }
               for(int[] dir : directions){
                 int nrow = dir[0] + row;
                 int ncol = dir[1] + col;
                 if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && maze[nrow][ncol] == '.'){
                    maze[nrow][ncol] = '+';
                    que.add(new Pair(nrow,ncol));
                 }
               }
            }
            steps++;
        }
        return -1;
    }
}