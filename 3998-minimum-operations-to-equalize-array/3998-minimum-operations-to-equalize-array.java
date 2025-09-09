class Solution {
    public int minOperations(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        if(nums[0] == nums[n - 1])return 0;
        return 1;
    }
}