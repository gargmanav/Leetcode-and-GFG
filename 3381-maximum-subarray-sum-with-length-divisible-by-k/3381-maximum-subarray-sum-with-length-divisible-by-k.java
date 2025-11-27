class Solution {
    public long maxSubarraySum(int[] nums, int k) {

        // Map: remainder -> minimum prefix sum seen for this remainder
        HashMap<Integer, Long> map = new HashMap<>();

        long prefixSum = 0;
        long ans = Long.MIN_VALUE;

        // Why? Because:
        // Index = -1 ka prefix sum = 0 hota hai
        // (-1 % k + k) % k = k - 1  → remainder = k-1
        // Isliye hum remainder (k-1) ke liye prefix 0 store kar dete hai
        map.put(k - 1, 0L);

        for (int i = 0; i < nums.length; i++) {

            // Prefix sum update
            prefixSum += nums[i];

            // Current index ka remainder
            int rem = i % k;

            // Agar same remainder ka prefix sum map me pehle se hai
            // then (prefixSum - minPrefix) ek valid subarray sum banata hai
            if (map.containsKey(rem)) {
                long minPrefix = map.get(rem);
                long subarraySum = prefixSum - minPrefix;
                ans = Math.max(ans, subarraySum);
            }

            // Update minimum prefix sum for this remainder
            // (taaki future me maximum difference mile)
            long old = map.getOrDefault(rem, Long.MAX_VALUE);
            map.put(rem, Math.min(old, prefixSum));
        }

        return ans;
    }
}
