class Solution {
    private boolean checkpossible(int mid,int m,int k,int[] bloomDay){
        int count = 0;
        int bouq = 0;
        for(int day : bloomDay){
            if(day <= mid){
                count++;
                if(count == k){
                    bouq++;
                    count = 0;
                }
            }else{
                count = 0;
            }
        }
        return bouq >= m;
    }
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if(n < m*k)return -1;
        int low = 1;
        int high = Arrays.stream(bloomDay).max().getAsInt();
        int ans = -1;
        while(low <= high){
            int mid = low + (high - low)/2;
            if(checkpossible(mid,m,k,bloomDay)){
                ans = mid;
                high = mid - 1;
            }else low = mid + 1;
        }
        return ans;
    }
}