import java.util.*;

class Solution {
    public long maximumTotalDamage(int[] power) {
        Map<Integer, Long> damageMap = new HashMap<>();

        for (int p : power) {
            damageMap.put(p, damageMap.getOrDefault(p, 0L) + p);
        }

        // Get unique sorted powers
        List<Integer> keys = new ArrayList<>(damageMap.keySet());
        Collections.sort(keys);

        int n = keys.size();
        long[] dp = new long[n];

        dp[0] = damageMap.get(keys.get(0));

        for (int i = 1; i < n; i++) {
            int curr = keys.get(i);
            long currDamage = damageMap.get(curr);

            // Option 1: skip current
            dp[i] = dp[i - 1];

            // Option 2: take current and add dp[j] (where keys[j] <= curr - 3)
            int j = i - 1;
            while (j >= 0 && keys.get(j) >= curr - 2) {
                j--;
            }
            long include = currDamage + (j >= 0 ? dp[j] : 0);
            dp[i] = Math.max(dp[i], include);
        }

        return dp[n - 1];
    }
}
