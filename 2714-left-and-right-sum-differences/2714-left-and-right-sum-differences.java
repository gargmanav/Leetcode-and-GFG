class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        if(n == 1)return new int[]{0};
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int count = 0;
        for(int i = 0;i<n;i++){
            prefix[i] = count;
            count += nums[i];
        }
        count = 0;
        for(int j = n - 1;j >= 0;j--){
            suffix[j] = count;
            count += nums[j];
        }
        for(int i = 0;i < n;i++){
           nums[i] = Math.abs(prefix[i] - suffix[i]);
        }
        return nums;
    }
}