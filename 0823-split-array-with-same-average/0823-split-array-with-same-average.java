class Solution {
     Map<String,Boolean> memo = new HashMap<>();
    public boolean splitArraySameAverage(int[] nums) {
        int N = nums.length;
        int sum = Arrays.stream(nums).sum();
        Arrays.sort(nums);
        for(int k = 1;k<N;k++){
            if((sum * k) % N != 0)continue;
                int target = (sum*k) / N;
                if(checkisSubsetpossible(nums,0,k,target)){
                    return true;
                }

            
        }
        return false;
    }
    private boolean checkisSubsetpossible(int[] nums,int index,int k,int target){
        if(k == 0)return target == 0;
        if(index == nums.length)return false;
         
        String key = index +","+k+","+target;
        if(memo.containsKey(key)){
            return memo.get(key);
        }

        if(nums[index] <= target && checkisSubsetpossible(nums,index + 1,k - 1,target - nums[index])){
            memo.put(key,true);
            return true;
        }
        if(checkisSubsetpossible(nums,index + 1,k,target)){
            memo.put(key,true);
            return true;
        }
        memo.put(key,false);
        return false;
    }
}