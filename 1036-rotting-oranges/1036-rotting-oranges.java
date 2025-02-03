class Pair{
    int row;
    int col;
    int tm;
    Pair(int row,int col,int tm){
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> qu = new LinkedList<>();
        int[][] vis = new int[n][m];
        int freshCount = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 2){
                    qu.add(new Pair(i,j,0));
                    vis[i][j] = 2;
                }else{
                    vis[i][j] = 0;
                }
                if(grid[i][j] == 1)freshCount++;
            }
        }
        int tm = 0;
        int drow[] = {-1,0,+1,0};
        int dcol[] = {0,1,0,-1};
        int count = 0;
        while(!qu.isEmpty()){
            int r = qu.peek().row;
            int c = qu.peek().col;
            int t  = qu.peek().tm;
            tm = Math.max(tm,t);
            qu.remove();
            for(int i = 0;i<4;i++){
                int nrow = r + drow[i];
                int ncol = c + dcol[i];
                if(nrow >=0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 2 && grid[nrow][ncol] == 1){
                    qu.add(new Pair(nrow,ncol,tm + 1));
                    count++;
                    vis[nrow][ncol] = 2;
                }
            }
        }
        if(count != freshCount)return -1;
        return tm;
    }
}