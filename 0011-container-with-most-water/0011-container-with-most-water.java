class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int max = 0;
        int l = 0,r = n - 1;
        while(l < r){
            int min = Math.min(height[l],height[r]);
            int win = r - l;
            int curr = min * win;
            max = Math.max(max,curr);
            if(height[l] < height[r]){
                l++;
            }else r--;
        }
        return max;
    }
}