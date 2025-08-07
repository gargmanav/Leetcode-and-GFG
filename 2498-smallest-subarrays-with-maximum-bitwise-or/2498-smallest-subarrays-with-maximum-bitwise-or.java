class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int[] setbitindex = new int[32];
        Arrays.fill(setbitindex, -1);

        for (int i = n - 1; i >= 0; i--) {
            // Update the last seen index for all bits set in nums[i]
            for (int j = 0; j < 32; j++) {
                if ((nums[i] & (1 << j)) != 0) {
                    setbitindex[j] = i;
                }
            }

            // Determine the farthest index needed to get the max OR
            int endindex = i;
            for (int j = 0; j < 32; j++) {
                if (setbitindex[j] != -1) {
                    endindex = Math.max(endindex, setbitindex[j]);
                }
            }

            result[i] = endindex - i + 1;
        }

        return result;
    }
}
