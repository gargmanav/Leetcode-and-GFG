class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int even = 0,odd = 0;
        for(int i : nums1){
            if(i % 2 == 0){
                even++;
            }else odd++;
        }
        if(even == n)return true;
        if(odd == n)return true;
        if(even >= 1 && odd >= 1)return true;
        return false;
    }
}