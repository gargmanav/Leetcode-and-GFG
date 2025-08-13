class Solution {
    public int[] productQueries(int n, int[][] queries) {
        final int MOD = 1_000_000_007;

        // Step 1: Extract powers of two from n
        java.util.List<Integer> powers = new java.util.ArrayList<>();
        for (int i = 0; i < 32; i++) {
            if (((n >> i) & 1) == 1) {
                powers.add(1 << i);
            }
        }

        // Step 2: Answer each query
        int q = queries.length;
        int[] ans = new int[q];
        for (int i = 0; i < q; i++) {
            long prod = 1;
            for (int j = queries[i][0]; j <= queries[i][1]; j++) {
                prod = (prod * powers.get(j)) % MOD;
            }
            ans[i] = (int) prod;
        }

        return ans;
    }
}
