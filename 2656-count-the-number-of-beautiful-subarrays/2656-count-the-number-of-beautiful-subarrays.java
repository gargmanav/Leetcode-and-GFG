class Solution {
    public long beautifulSubarrays(int[] nums) {
         Map<Integer, Long> prefixXorCount = new HashMap<>();
        prefixXorCount.put(0, 1L); // base case: XOR is 0 before starting
        long count = 0;
        int xor = 0;

        for (int num : nums) {
            xor ^= num;
            count += prefixXorCount.getOrDefault(xor, 0L);
            prefixXorCount.put(xor, prefixXorCount.getOrDefault(xor, 0L) + 1);
        }

        return count;
    }
}