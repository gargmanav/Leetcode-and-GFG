class Solution {
    public int removeDuplicates(int[] nums) {
       if(nums.length == 0)return 0;
       int first = 1;
       for(int j = 1;j<nums.length;j++){
          if(nums[j] != nums[j-1]){
            nums[first] = nums[j];
            first++;
          }
       }
       return first;
    }
}