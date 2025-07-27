class Solution {
    public List<Integer> goodDaysToRobBank(int[] nums, int time) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        for(int i = 0;i<n;i++){
            if(i >= 1 && nums[i - 1] >= nums[i]){
                prefix[i] = prefix[i - 1] + 1;
            }else prefix[i] = 0;  
        }
       
        for(int i = n - 1;i>=0;i--){
            if(i <= n - 2 && nums[i + 1] >= nums[i]){
                suffix[i] = suffix[i + 1] + 1;
            }else suffix[i] = 0;  
        }
        
        List<Integer> temp = new ArrayList<>();
        for(int i = 0;i < n;i++){
            if(prefix[i] >= time && suffix[i] >= time){
                temp.add(i);
            }
        }
        return temp;
    }
}