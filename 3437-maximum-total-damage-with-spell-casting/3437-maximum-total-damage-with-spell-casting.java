class Solution {
    private long solve(int index, List<Integer> uniquepower, Map<Integer, Integer> map,long[] dp) {
        if (index >= uniquepower.size()) {
            return 0;
        }
        if(dp[index] != -1){
            return dp[index];
        }
        int newindex = index + 1;

        // FIXED BOUNDS CHECK
        while (newindex < uniquepower.size() && 
               uniquepower.get(newindex) <= uniquepower.get(index) + 2) {
            newindex++;
        }

        long pick = (long) map.get(uniquepower.get(index)) * uniquepower.get(index) 
                    + solve(newindex, uniquepower, map,dp);

        long notpick = solve(index + 1, uniquepower, map,dp);
        dp[index] = Math.max(pick, notpick);
        return dp[index];
    }

    public long maximumTotalDamage(int[] power) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : power) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        long[] dp = new long[power.length];
        Arrays.fill(dp,-1);
        List<Integer> uniquepower = new ArrayList<>(map.keySet());
        return solve(0, uniquepower, map,dp);
    }
}
