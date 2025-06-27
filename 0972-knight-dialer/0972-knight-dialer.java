class Solution {
    public int knightDialer(int n) {
        int mod = 1_000_000_007;

        int[][] moves = {
            {4,6},    // 0
            {6,8},    // 1
            {7,9},    // 2
            {4,8},    // 3
            {3,9,0},  // 4
            {},       // 5 (invalid)
            {1,7,0},  // 6
            {2,6},    // 7
            {1,3},    // 8
            {2,4}     // 9
        };

        long[] prev = new long[10];
        // Base case: for length = 1, every digit has count 1
        Arrays.fill(prev, 1);

        for (int i = 2; i <= n; i++) {
            long[] curr = new long[10];
            for (int digit = 0; digit <= 9; digit++) {
                for (int nei : moves[digit]) {
                    curr[digit] = (curr[digit] + prev[nei]) % mod;
                }
            }
            prev = curr;
        }

        long result = 0;
        for (long val : prev) {
            result = (result + val) % mod;
        }

        return (int) result;
    }
}