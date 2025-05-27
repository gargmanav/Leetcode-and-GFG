class Solution {
    public int differenceOfSums(int n, int m) {
        int nsum = 0;
        int msum = 0;
        for(int i = 1;i<=n;i++){
            if(i % m != 0){
                nsum += i;
            }else{
                msum += i;
            }
        }
        return nsum - msum;
    }
}