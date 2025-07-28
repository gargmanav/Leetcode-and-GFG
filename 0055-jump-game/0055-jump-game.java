class Solution {
    private int[] memo;
    private boolean helper(int index,int[] nums){
        if(index >= nums.length - 1)return true;
        if(memo[index] != -1)return memo[index] == 0 ? false : true;
        boolean ans = false;
        for(int i = 1;i<=nums[index];i++){
           ans = ans || helper(index + i,nums);
        }
        memo[index] = ans == false ? 0 : 1;
        return ans;
    }
    public boolean canJump(int[] nums) {
        if(nums.length == 1)return true;
        memo = new int[nums.length];
        Arrays.fill(memo,-1);
        return helper(0,nums);
    }
}