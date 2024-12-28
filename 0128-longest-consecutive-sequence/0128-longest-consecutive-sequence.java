class Solution {
     public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Arrays.sort(nums);

        int maxCount = 1;
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // Skip duplicates
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                // If consecutive, increase count
                count++;
                maxCount = Math.max(maxCount, count);
            } else {
                // Reset count if not consecutive
                count = 1;
            }
        }

        return maxCount;
    }
}