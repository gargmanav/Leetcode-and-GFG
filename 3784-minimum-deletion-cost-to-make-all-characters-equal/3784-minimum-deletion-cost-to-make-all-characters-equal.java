class Solution {
    public long minCost(String s, int[] cost) {
        int n = cost.length;
        long[] freq = new long[26];
        Arrays.fill(freq,0);
        long totalcost = 0;
        for(int i = 0;i < n;i++){
            int ch = s.charAt(i) - 'a';
            freq[ch] += cost[i];
            totalcost += cost[i];
        }
        long maxsaved = 0;
        for(int i = 0;i < 26;i++){
           maxsaved = Math.max(maxsaved,freq[i]);
        }
        return totalcost - maxsaved;
    }
}