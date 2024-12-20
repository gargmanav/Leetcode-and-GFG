class Solution {
    public int[] rearrangeArray(int[] nums) {
       int N = nums.length;
        int pi = 0;
        int ni = 1;
        int[] arr = new int[N];
         for(int num : nums){
            if(num >=0){
            arr[pi] = num;
            pi += 2;
            }else{
            arr[ni] = num;
            ni += 2;
            }
        }
        return arr; 
    }
}