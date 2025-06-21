class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
         Map<Integer, Integer> prefixSumCount = new HashMap<>();
        prefixSumCount.put(0, 1); // to handle subarrays starting from index 0

        int currSum = 0;
        int count = 0;

        for (int num : nums) {
            currSum += num;

            // Check if there's a prefix sum such that currSum - prefix = goal
            if (prefixSumCount.containsKey(currSum - goal)) {
                count += prefixSumCount.get(currSum - goal);
            }

            // Update the map with current prefix sum count
            prefixSumCount.put(currSum, prefixSumCount.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}