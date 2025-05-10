class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            // If the number is already in the set, we found a duplicate within range k
            if (set.contains(nums[i])) {
                return true;
            }

            // Add the current number to the set
            set.add(nums[i]);

            // If the set size exceeds k, remove the oldest element (i - k)
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }

        return false;
    }
}