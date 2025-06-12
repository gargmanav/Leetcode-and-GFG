class Solution {
    private int[][] options = {{100,0},{75,25},{50,50},{25,75}};
    private Map<String, Double> memo = new HashMap<>();

    public double solve(double A, double B) {
        if (A <= 0 && B <= 0) return 0.5;
        if (A <= 0) return 1.0;
        if (B <= 0) return 0.0;

        String key = (int)A + "," + (int)B;
        if (memo.containsKey(key)) return memo.get(key);

        double prob = 0.0;
        for (int[] arr : options) {
            prob += solve(A - arr[0], B - arr[1]);
        }

        prob *= 0.25;
        memo.put(key, prob);
        return prob;
    }

    public double soupServings(int n) {
        if (n >= 5000) return 1.0; // Optimization for large n
        return solve(n, n);
    }
}
