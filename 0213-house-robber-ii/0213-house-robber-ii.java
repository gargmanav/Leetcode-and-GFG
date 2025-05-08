class Solution {
    public int rob(int[] nums) {
        if(nums.length == 0)return 0;
        if(nums.length == 1)return nums[0];
        if(nums.length == 2)return Math.max(nums[0],nums[1]);
        int n = nums.length;

        int first = robLinear(nums,0,n - 2);
        int second = robLinear(nums,1, n - 1);

        return Math.max(first,second);
    }

    private int robLinear(int[] nums, int start, int end) {
        int prev1 = 0, prev2 = 0;
        for (int i = start; i <= end; i++) {
            int temp = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = temp;
        }
        return prev1;
    }
}