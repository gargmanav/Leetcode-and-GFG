class Solution {
    public int subarraySum(int[] nums, int k) {
        int curSum = 0;
        int count = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1); // Initialize to handle the case where curSum == k
        
        for (int i = 0; i < nums.length; i++) {
            curSum += nums[i];
            
            // Check if there's a subarray ending at the current index with sum == k
            if (map.containsKey(curSum - k)) {
                count += map.get(curSum - k);
            }
            
            // Update the hashmap with the current cumulative sum
            map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        }
        return count;
    }
}