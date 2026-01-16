class Solution {
    public int maximizeSquareHoleArea(int n, int m, int[] h, int[] v) {
        Arrays.sort(h);
        Arrays.sort(v);
        int first = 1,second = 1;
        int count = 1;
        for(int i = 1;i < h.length;i++){
            if(h[i] == h[i - 1] + 1)count++;
            else count = 1;
            first = Math.max(first,count);
        }
        count = 1;
        for(int j = 1;j < v.length;j++){
            if(v[j] == v[j - 1] + 1)count++;
            else count = 1;
            second = Math.max(second,count);
        }
        int ans = Math.min(first,second) + 1;
        return ans * ans;
    }
}