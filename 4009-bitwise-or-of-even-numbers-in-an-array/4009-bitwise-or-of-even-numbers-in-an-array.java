class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++){
            if(nums[i] % 2 == 0){
                ans = ans | nums[i];
            }
        }
        return ans;
    }
}