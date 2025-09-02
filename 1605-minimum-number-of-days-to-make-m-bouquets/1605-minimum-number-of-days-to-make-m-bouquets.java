class Solution {
    private boolean checkday(int target,int[] bloomDay,int m,int k){
        int count = 0;
        int kcount = 0;
        for(int i = 0;i < bloomDay.length;i++){
            if(bloomDay[i] <= target){
                kcount++;
                if(kcount == k){
                    kcount=0;
                   count++;
                }
            }else kcount = 0;
        }
        return count >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m * k)return -1;
        int low = Arrays.stream(bloomDay).min().getAsInt();
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int minimumdays = Integer.MAX_VALUE;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(checkday(mid,bloomDay,m,k)){
                minimumdays = Math.min(minimumdays,mid);
                high = mid - 1;
            }
            else low = mid + 1;
        }
        return minimumdays == Integer.MAX_VALUE ? -1 : minimumdays;
    }
}