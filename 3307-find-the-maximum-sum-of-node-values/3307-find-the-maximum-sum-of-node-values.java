class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        long total = 0;
        int xorCount = 0;
        int minDiff = Integer.MAX_VALUE;

        for (int num : nums) {
            int xorVal = num ^ k;
            if (xorVal > num) {
                total += xorVal;
                xorCount++;
                minDiff = Math.min(minDiff, xorVal - num);
            } else {
                total += num;
                minDiff = Math.min(minDiff, num - xorVal);
            }
        }
        if (xorCount % 2 == 0) {
            return total;
        } else {
            return total - minDiff;
        }
    }
}