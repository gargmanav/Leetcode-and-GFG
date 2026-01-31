class Solution {

    public long findminimum(int k, int[] nums) {
        long ops = 0;
        for (int num : nums) {
            ops += (num + k - 1) / k;
        }
        return ops;
    }

    public int minimumK(int[] nums) {
        int low = 1;
        int high = 1000000;
        

        int ans = 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (findminimum(mid, nums) <= (long) mid * mid) {
                ans = mid; 
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
}
