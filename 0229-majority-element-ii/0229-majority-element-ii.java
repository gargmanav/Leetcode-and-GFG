class Solution {
    public List<Integer> majorityElement(int[] nums) {
        if(nums.length == 1)return Arrays.asList(nums[0]);
        int n = nums.length;
        int majoritycount = n/3;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i,map.getOrDefault(i,0)+1);
        }

        List<Integer> arr = new ArrayList<>();
        map.forEach((k,v)->{
         if(v > majoritycount){
            arr.add(k);
         }
        });
        return arr;
    }
}