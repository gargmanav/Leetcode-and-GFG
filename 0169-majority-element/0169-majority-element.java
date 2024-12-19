class Solution {
    public int majorityElement(int[] nums) {
       int el = 0;
       int count = 0;
       for(int num : nums){
          if(count == 0){
            el = num;
          }
          count += (num == el)? 1 : -1;
       }
       return el;
    }
}