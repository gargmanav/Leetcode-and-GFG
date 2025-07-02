class Solution {
    private boolean canEatAll(int k, int h, int[] piles) {
        long hours = 0;
    for (int pile : piles) {
        hours += (long)Math.ceil((double)pile / k);
    }
    return hours <= h;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int low = 1;
        int high = Arrays.stream(piles).max().getAsInt();
        int answer = high;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (canEatAll(mid, h, piles)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return answer;
    }
}
