class Solution {
    private boolean checkabsolutediffpossible(int[] price,int k,int mid){
        int count = 1;
        int latervalue = price[0];
        for(int i = 1;i<price.length;i++){
            if(price[i] - latervalue >= mid){
                count++;
                latervalue = price[i];
                if(count == k)return true;
            }
        }
        return false;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;
        int left = 0;
        int right = price[n - 1] - price[0];
        int ans = Integer.MIN_VALUE;
        while(left <= right){
            int mid = (left + right) / 2;
            if(checkabsolutediffpossible(price,k,mid)){
               ans = mid;
               left = mid + 1;
            }else right = mid - 1;
        }
        return ans;
    }
}