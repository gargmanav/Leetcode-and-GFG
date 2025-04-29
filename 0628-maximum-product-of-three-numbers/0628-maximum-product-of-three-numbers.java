class Solution {
    public int maximumProduct(int[] nums) {
        if(nums.length == 3)return (nums[0] * nums[1] * nums[2]);
        int n = nums.length;
        Arrays.sort(nums);
        int Productoffirsttwo = nums[0] * nums[1] * nums[n-1];;
        int Productoflastthree = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int res = Math.max(Productoffirsttwo,Productoflastthree);
        return res;
    }
}