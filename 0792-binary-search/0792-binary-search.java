class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;
        int low = 0,end = n - 1;
        while(low <= end){
            int mid = (low + end)/2;
            if(nums[mid] == target)return mid;
            if(nums[mid] < target){
                low = mid + 1;
            }else end = mid - 1;
        }
        return -1;
    }
}