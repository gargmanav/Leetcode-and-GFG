class Solution {
    public int solve(List<Integer> temp){
        List<Integer> arr = new ArrayList<>();
        for(int x : temp){
            int idx = Collections.binarySearch(arr,x);
            if(idx < 0) idx = -idx - 1;

            if(idx == arr.size()){
                arr.add(x);
            }else{
                arr.set(idx,x);
            }
        }
        return arr.size();
    }
    public int longestSubsequence(int[] nums) {
        int ans = 0;
        for(int i = 0;i < 31;i++){
            List<Integer> temp = new ArrayList<>();
            for(int num : nums){
                if(((num >> i) & 1) != 0){
                    temp.add(num);
                }
            }
            ans = Math.max(ans, solve(temp));
        }
        return ans;
    }
}