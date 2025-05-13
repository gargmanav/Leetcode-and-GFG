class Solution {
    public int findMin(int[] nums) {
         int n = nums.length;
        int start = 0, end = n - 1;

        // If the array is not rotated (sorted in increasing order)
        if (nums[start] <= nums[end]) {
            return nums[start];
        }

        while (start <= end) {
            int mid = start + (end - start) / 2;

            // Check if mid is the minimum
            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }

            // Check if mid+1 is the minimum
            if (mid < n - 1 && nums[mid] > nums[mid + 1]) {
                return nums[mid + 1];
            }

            // Decide the side to go
            if (nums[mid] >= nums[start]) {
                // Left part is sorted, move to right part
                start = mid + 1;
            } else {
                // Right part is sorted, move to left part
                end = mid - 1;
            }
        }

        return -1;
    }
}