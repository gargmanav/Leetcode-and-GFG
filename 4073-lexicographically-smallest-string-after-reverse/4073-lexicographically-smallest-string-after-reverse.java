class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String ans = s;
        for(int k = 1;k <= n;k++){
            String firstk = new StringBuilder(s.substring(0,k)).reverse().toString();
            String leftone = firstk + s.substring(k);
            if(leftone.compareTo(ans) < 0){
                ans = leftone;
            }
        }
        for(int k = 1;k <= n;k++){
            String lastk = new StringBuilder(s.substring(n - k)).reverse().toString();
            String leftone = s.substring(0,n - k) + lastk;
            if(leftone.compareTo(ans) < 0){
                ans = leftone;
            }
        }
        return ans;
    }
}