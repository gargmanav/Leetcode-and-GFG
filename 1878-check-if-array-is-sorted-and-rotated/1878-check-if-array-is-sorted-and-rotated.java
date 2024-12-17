class Solution {
    public boolean check(int[] nums) {
        int count = 0; 
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            
            if (nums[i] > nums[(i + 1) % n]) {
                count++;
            }
        }
        
        // If there is at most one breakpoint, it's a rotated sorted array
        return count <= 1;
    }
}