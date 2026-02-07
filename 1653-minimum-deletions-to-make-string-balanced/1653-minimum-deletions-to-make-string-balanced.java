class Solution {
    String s;
    int n;
    public int minimumDeletions(String s) {
       int bcount = 0;
       int deletion = 0;
       for(char ch : s.toCharArray()){
         if(ch == 'b'){
            bcount++;
         }else{
            deletion = Math.min(deletion + 1,bcount);
         }
       }
       return deletion;
    }
}