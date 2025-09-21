class Solution {
    public long maxTotalValue(int[] nums, int k) {
        int max = nums[0], min = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
            if (num < min) min = num;
        }
        long ans = max - min;
        return ans * k;
    }
}