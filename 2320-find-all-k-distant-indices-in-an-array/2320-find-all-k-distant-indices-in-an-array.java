class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer> keys = new ArrayList<>();
        int n = nums.length;
        for(int i = 0;i<n;i++){
            if(nums[i] == key){
                keys.add(i);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j : keys){
                int num = Math.abs(i - j);
                if(num <= k){
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}