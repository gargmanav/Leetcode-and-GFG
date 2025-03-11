class Solution {
    int[][] directions = {
        {-1,0},{1,0},{0,-1},{0,1}
    };
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        
        int freshOranges = 0;

        Queue<Pair> que = new LinkedList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j < m;j++){
                if(grid[i][j] == 2){
                    que.add(new Pair(i,j));
                }else if(grid[i][j] == 1){
                    freshOranges++;
                }
            }
        }
        if(freshOranges == 0)return 0;
        int minutes = 0;
        while(!que.isEmpty()){
            
           int size = que.size();
           while(size-- > 0){
              Pair curr = que.poll();
              int i = curr.i;
              int j = curr.j;
              for(int[] dir : directions){
                 int newI = i + dir[0];
                 int newJ = j + dir[1];

                 if(newI >= 0 && newI < n && newJ >= 0 && newJ < m && grid[newI][newJ] == 1){
                    grid[newI][newJ] = 2;
                    que.add(new Pair(newI,newJ));
                    freshOranges--;
                    
                 }
              }
               
           }
           minutes++;

        }
        return (freshOranges == 0) ? minutes - 1 : -1;
    }
}

class Pair {
    int i,j;
    public Pair(int i,int j){
        this.i = i;
        this.j = j;
    }
}