class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        int n = nums.length;
        List<Boolean> result = new ArrayList<>();
        int x = 0;

        for (int i = 0; i < n; i++) {
            x = (2 * x + nums[i]) % 5;

            result.add(x == 0);
        }

        return result;
    }
}
