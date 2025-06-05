class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int left = 1;
        int right = getMax(nums);  // max element in array
        int answer = right;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (computeSum(nums, mid) <= threshold) {
                answer = mid; // potential answer found
                right = mid - 1; // try smaller divisor
            } else {
                left = mid + 1; // need bigger divisor
            }
        }

        return answer;
    }

    // Helper to get the max value in the array
    private int getMax(int[] nums) {
        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;
    }

    // Compute the sum of ceil(nums[i] / divisor)
    private int computeSum(int[] nums, int divisor) {
        int sum = 0;
        for (int num : nums) {
            sum += (num + divisor - 1) / divisor;  // same as ceil(num / divisor)
        }
        return sum;
    }
}