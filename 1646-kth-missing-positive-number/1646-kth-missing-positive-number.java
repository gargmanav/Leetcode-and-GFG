class Solution {
    public int findKthPositive(int[] arr, int k) {
        int n = arr.length;
        int low = 0,high = n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int kitnemissingtillend = arr[mid] - (mid + 1);
            if(kitnemissingtillend < k){
                low = mid + 1;
            }else high = mid - 1;
        }
        return low + k;
    }
}