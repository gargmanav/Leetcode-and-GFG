class Solution {
    public int findLHS(int[] nums) {
        int max = 0;
        int n = nums.length;
        Map<Integer,Integer> map = new HashMap<>();
        for(int num : nums){
          map.put(num,map.getOrDefault(num,0) + 1);
        }
        for(int i = 0;i<n;i++){
            if(map.containsKey(nums[i] + 1)){
                max = Math.max(max,map.get(nums[i]) + map.get(nums[i] + 1));
            }
        }
        return max;
    }
}