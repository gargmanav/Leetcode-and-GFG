class Solution {
    public int maximumTastiness(int[] price, int k) {
         Arrays.sort(price); // Step 1: Sort the prices

        int left = 0;
        int right = price[price.length - 1] - price[0];
        int ans = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (canPickWithMinDiff(price, k, mid)) {
                ans = mid;          // mid is a valid answer
                left = mid + 1;     // try for bigger tastiness
            } else {
                right = mid - 1;    // try smaller tastiness
            }
        }

        return ans;
    }

    private boolean canPickWithMinDiff(int[] price, int k, int minDiff) {
        int count = 1;
        int lastPicked = price[0];

        for (int i = 1; i < price.length; i++) {
            if (price[i] - lastPicked >= minDiff) {
                count++;
                lastPicked = price[i];
                if (count == k) return true;
            }
        }

        return false;
    }
}