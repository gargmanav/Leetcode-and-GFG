class Solution {
    int n;
    private int dfs(List<List<Integer>> triangle,int row ,int col,int[][] memo){
        if(row == n - 1){
            return triangle.get(row).get(col);
        }
        if(memo[row][col] != -1){
            return memo[row][col];
        }

        int left = dfs(triangle,row + 1,col,memo);
        int right = dfs(triangle,row + 1,col + 1,memo);

        return memo[row][col] = triangle.get(row).get(col) + Math.min(left,right);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        n = triangle.size();
        int[][] memo = new int[n][n];
        for(int[] arr: memo){
            Arrays.fill(arr,-1);
        }
        return dfs(triangle,0,0,memo);
    }
}