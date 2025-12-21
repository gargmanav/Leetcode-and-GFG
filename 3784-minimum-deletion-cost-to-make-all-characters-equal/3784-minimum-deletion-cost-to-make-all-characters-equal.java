class Solution {
    public long minCost(String s, int[] cost) {
        long totalCost = 0;
        long[] keep = new long[26]; // cost sum for each character

        for (int i = 0; i < s.length(); i++) {
            int idx = s.charAt(i) - 'a';
            keep[idx] += cost[i];
            totalCost += cost[i];
        }

        long maxKeep = 0;
        for (long val : keep) {
            maxKeep = Math.max(maxKeep, val);
        }

        return totalCost - maxKeep;
    }
}
