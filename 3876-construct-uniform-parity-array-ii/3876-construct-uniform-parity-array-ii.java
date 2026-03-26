class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int mineven = Integer.MAX_VALUE, minodd = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++){
            if(nums1[i] % 2 == 0){
                mineven = Math.min(mineven,nums1[i]);
            }else{
                minodd = Math.min(minodd,nums1[i]);
            }
        }
        if(mineven == Integer.MAX_VALUE || minodd == Integer.MAX_VALUE)return true;
        if(mineven - minodd >= 1)return true;
        return false;
    }
}