class Solution {
    public int missingNumber(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for (int num : nums) {
            hs.add(num);
        }
        for(int i = 0;i<=nums.length;i++){
            if(!hs.contains(i)){
               return i;
            }
        }
        return nums.length;
    }
}