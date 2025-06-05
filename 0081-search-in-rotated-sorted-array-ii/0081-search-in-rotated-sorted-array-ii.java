class Solution {
    public boolean search(int[] nums, int target) {
     int left = 0, right = nums.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;

            // If we found the target
            if (nums[mid] == target) {
                return true;
            }

            // If duplicates, move left pointer
            if (nums[left] == nums[mid]) {
                left++;
            }
            // Left part is sorted
            else if (nums[left] < nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // Search in left part
                } else {
                    left = mid + 1; // Search in right part
                }
            }
            // Right part is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in right part
                } else {
                    right = mid - 1; // Search in left part
                }
            }
        }

        return false;
    }
}