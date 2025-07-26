class Solution {
    public int waysToMakeFair(int[] nums) {
        int n = nums.length;
        int totalEven = 0, totalOdd = 0;

        // Calculate total even and odd sums
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) totalEven += nums[i];
            else totalOdd += nums[i];
        }

        int res = 0;
        int leftEven = 0, leftOdd = 0;

        for (int i = 0; i < n; i++) {
            // Remove nums[i], adjust total sums
            if (i % 2 == 0) totalEven -= nums[i];
            else totalOdd -= nums[i];

            // After removing i, the elements after i will shift:
            // even <-> odd
            int newEven = leftEven + totalOdd;
            int newOdd = leftOdd + totalEven;

            if (newEven == newOdd) res++;

            // Update left prefix sums
            if (i % 2 == 0) leftEven += nums[i];
            else leftOdd += nums[i];
        }

        return res;
    }
}
