class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(k > n)return 0;
        int PointSum = Arrays.stream(cardPoints).sum();
        int currentWindowSize = n - k;
        int windowsum = 0;
        for(int i = 0;i<currentWindowSize;i++){
          windowsum += cardPoints[i];
        }
        int minwindowsum = windowsum;
        for(int i = currentWindowSize;i<n;i++){
            windowsum = windowsum + cardPoints[i] - cardPoints[i - currentWindowSize];
            minwindowsum = Math.min(minwindowsum,windowsum);
        }
        return PointSum - minwindowsum;
    }
}