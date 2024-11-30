class Solution {
    public void performRecur(List<List<Integer>> ans,List<Integer> ds,boolean[] freq,int[] nums){
        if(ds.size() == nums.length){
            ans.add(new ArrayList<>(ds));
            return;
        }
        for(int i = 0;i<nums.length;i++){
            if(!freq[i]){
                if(i > 0 && nums[i] == nums[i-1] && !freq[i - 1])continue;
                freq[i] = true;
                ds.add(nums[i]);
                performRecur(ans,ds,freq,nums);
                ds.remove(ds.size()-1);
                freq[i] = false;
            }
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] freq = new boolean[nums.length];
        performRecur(ans,ds,freq,nums);
        return ans;
    }
}