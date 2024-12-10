class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        solve("",0,0,n,result);
        return result;
    }
    public void solve(String curr,int open,int close,int n,List<String> result){
        if(curr.length() == 2*n){
            result.add(curr);
            return;
        }
        if(open < n){
            solve(curr+"(",open+1,close,n,result);
        }
        if(close < open){
            solve(curr+")",open,close+1,n,result);
        }
    }
}