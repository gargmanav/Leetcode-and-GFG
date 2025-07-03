class Solution {
    private int modulo = 1000000007;

    public int matpow(long a,long b){
        if(b == 0)return 1;
        long half = matpow(a,b/2);
        long result = (half * half) % modulo;
        if(b % 2 == 1){
            result = (result * a) % modulo;
        }
        return (int)result;
    }
    public int countGoodNumbers(long n) {
        long evenpos = (n + 1)/2;
        long oddpos = n / 2;
        long a = matpow(5,evenpos);
        long b = matpow(4,oddpos);
        return (int) ((a * b) % modulo);
    }
}