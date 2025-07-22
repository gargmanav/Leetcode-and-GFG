class Solution {
    int[][] memo;
    private int findways(int[] nums, int target,int index,int currSum){
        if(index == nums.length){
            if(currSum == target){
            return 1;
        }
            return 0;
        }
        if(memo[index][currSum + 1000] != -1){
            return memo[index][currSum + 1000];
        }
        int adding = findways(nums,target,index + 1,currSum + nums[index]);
        int minus = findways(nums,target,index + 1,currSum - nums[index]);
        
        memo[index][currSum + 1000] = adding + minus;
        return memo[index][currSum + 1000];
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        memo = new int[nums.length][2001];
        for(int[] mem : memo){
            Arrays.fill(mem,-1);
        }
        return findways(nums,target,0,0);
    }
}