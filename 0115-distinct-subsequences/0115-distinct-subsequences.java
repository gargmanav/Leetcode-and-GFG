class Solution {
    int n,m;
    int[][] memo;
    private int CountSubsequences(int i,int j,String s, String t){
        if(j == m) return 1;
        if(i == n)return 0;
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        int total = 0;
        if(s.charAt(i) == t.charAt(j)){
            int take = CountSubsequences(i + 1,j + 1,s,t);
            int not_take = CountSubsequences(i + 1,j,s,t);
             total = take + not_take;
        }else{
             total = CountSubsequences(i + 1,j,s,t);
        }
        return memo[i][j] = total;
    }
    public int numDistinct(String s, String t) {
        n = s.length();
        m = t.length();
        memo = new int[n + 1][m + 1];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return CountSubsequences(0,0,s,t);
    }
}