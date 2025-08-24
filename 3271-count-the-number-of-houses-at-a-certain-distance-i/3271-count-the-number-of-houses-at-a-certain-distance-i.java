class Solution {
    public int[] countOfPairs(int n, int x, int y) {
        int[][] dist = new int[n][n];
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if(i == j) dist[i][j] = 0;
                else if(Math.abs(i-j) == 1 || (i+1==x && j+1==y) || (i+1==y && j+1==x)) dist[i][j] = 1;
                else dist[i][j] = 1000;
            }
        }
        for(int k=0; k<n; k++)
            for(int i=0; i<n; i++)
                for(int j=0; j<n; j++)
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
        int[] ans = new int[n];
        for(int i=0; i<n; i++)
            for(int j=0; j<n; j++)
                if(i != j && dist[i][j] < n)
                    ans[dist[i][j]-1]++;
        return ans;
    }
}