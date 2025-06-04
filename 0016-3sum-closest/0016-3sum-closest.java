class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums); // Step 1: Sort the array
        int closestSum = nums[0] + nums[1] + nums[2]; // Initial sum

        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;

            // Step 2: Use two pointers
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];

                // Update the closestSum if current one is closer to the target
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }

                // Move pointers based on the comparison
                if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return closestSum;
    }
}