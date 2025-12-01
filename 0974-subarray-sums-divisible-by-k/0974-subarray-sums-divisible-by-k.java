class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        int n = nums.length;
        int sum = 0;
        mp.put(sum,1);
        int result = 0;
        for(int i = 0;i < n;i++){
           sum += nums[i];
           int rem = sum % k;
           if(rem < 0){
            rem += k;
           }
           if(mp.containsKey(rem)){
            int curr = mp.get(rem);
            result +=curr;
           }
           mp.put(rem, mp.getOrDefault(rem, 0) + 1);
        }
        return result;
    }
}