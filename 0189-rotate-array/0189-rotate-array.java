class Solution {
    public void swap(int[] arr,int i ,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public void reverse(int[] arr,int i,int j){
        while(i < j){
            swap(arr,i,j);
            i++;
            j--;
        }
    }
    public void rotate(int[] nums, int k) {
         k = k % nums.length;
        if(k == 0)return;

        reverse(nums,0,nums.length - 1);
        reverse(nums,0,k - 1);
        reverse(nums,k,nums.length - 1);
    }
}