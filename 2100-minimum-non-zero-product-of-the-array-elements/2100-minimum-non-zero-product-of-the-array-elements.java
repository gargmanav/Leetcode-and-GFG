class Solution {
    private static final int MOD = 1_000_000_007;

    public int minNonZeroProduct(int p) {
        long maxNum = (1L << p) - 1;
        long base = maxNum - 1;
        long power = (1L << (p - 1)) - 1;
        long result = modPow(base, power, MOD);
        result = (result * (maxNum % MOD)) % MOD;
        return (int) result;
    }

    private long modPow(long base, long exp, int mod) {
        long result = 1;
        base %= mod;
        while (exp > 0) {
            if ((exp & 1) == 1) result = (result * base) % mod;
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }
}