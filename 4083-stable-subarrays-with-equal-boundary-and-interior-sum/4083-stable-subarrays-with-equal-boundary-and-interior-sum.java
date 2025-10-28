import java.util.*;

class Solution {
    public long countStableSubarrays(int[] capacity) {
        int n = capacity.length;
        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + capacity[i];
        }

        long ans = 0;
        Map<String, Integer> map = new HashMap<>();

        // We start from left to right
        for (int r = 2; r < n; r++) {  // r is at least 2 to ensure length >= 3
            // before processing r, add possible l = r - 2, r - 3 ... handled by map
            
            // add (capacity[r-2], prefix[r-1] + capacity[r-2]) to map
            long keyPrefix = prefix[r - 1] + capacity[r - 2];
            String key = capacity[r - 2] + "#" + keyPrefix;
            map.put(key, map.getOrDefault(key, 0) + 1);

            // now check if any l exists such that:
            // capacity[l] == capacity[r]
            // prefix[l+1] + capacity[l] == prefix[r]
            String lookup = capacity[r] + "#" + prefix[r];
            ans += map.getOrDefault(lookup, 0);
        }

        return ans;
    }
}
