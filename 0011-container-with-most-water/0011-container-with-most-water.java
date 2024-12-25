class Solution {
    public int maxArea(int[] height) {
        int i = 0,j = height.length - 1;
        int total = Integer.MIN_VALUE;
        while(i < j){
           int min = Math.min(height[i],height[j]);
           total = Math.max(total,(min * (j - i)));
           if(height[i] < height[j]){
            i++;
           }else j--;
        }
        return total;
    }
}