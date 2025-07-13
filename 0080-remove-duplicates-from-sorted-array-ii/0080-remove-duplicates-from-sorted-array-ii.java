class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0,j = 0,currCount = 0,result = 0;
        while(i <= j && j < nums.length){
            if(nums[i] == nums[j] && currCount < 2){
                currCount++;
                nums[result] = nums[j];
                result++;
            }else if(nums[i] != nums[j]){
                i = j;
                currCount= 1;
                nums[result] = nums[j];
                result++;
            }
            j++;
        }
        return result;
    }
}