class Solution {
    public boolean isPossibleDivide(int[] nums, int k) {
        int n = nums.length;
        if(n % k != 0)return false;
        TreeMap<Integer,Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        while(!map.isEmpty()){
            int min = map.firstKey();
            for(int i = 0;i<k;i++){
                if(!map.containsKey(min + i))return false;
                map.put(min + i,map.get(min + i) - 1);
                if(map.get(min + i) == 0){
                    map.remove(min + i);
                }
            }
        }
        return true;
    }
}