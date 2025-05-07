class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int windowSize = n - k;

        int total = 0;
        for (int point : cardPoints) {
            total += point;
        }

        int minSubarraySum = 0;
        for (int i = 0; i < windowSize; i++) {
            minSubarraySum += cardPoints[i];
        }

        int currentSum = minSubarraySum;
        for (int i = windowSize; i < n; i++) {
            currentSum += cardPoints[i] - cardPoints[i - windowSize];
            minSubarraySum = Math.min(minSubarraySum, currentSum);
        }

        return total - minSubarraySum;
    }
}