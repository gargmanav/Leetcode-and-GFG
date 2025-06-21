class Solution {
    public int longestOnes(int[] nums, int k) {
        int count = 0;
        int left = 0;
        int result = 0;
        for(int right = 0;right < nums.length;right++){
            count += nums[right];

            int window_size = right - left + 1;
            if(window_size - count > k){
                count -= nums[left];
                left++;
            }
            result = Math.max(result,right - left + 1);
        }
        return result;
    }
}