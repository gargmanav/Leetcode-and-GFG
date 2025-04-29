class Solution {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for (int num : nums) total += num;
        if (total % 2 != 0) return false;

        int target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];

        return canPartitionRecursive(nums, 0, target, memo);
    }

    private boolean canPartitionRecursive(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;
        if (memo[index][target] != null) return memo[index][target];

        boolean include = canPartitionRecursive(nums, index + 1, target - nums[index], memo);
        boolean exclude = canPartitionRecursive(nums, index + 1, target, memo);

        return memo[index][target] = include || exclude;
    }
}