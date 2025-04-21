class Solution {
    private boolean solve(int current_index,int prev_index,int[] stones,Map<Integer,Integer> map,int n,int[][] memo){
        if(current_index == n - 1){
            return true;
        }
        if(memo[current_index][prev_index] != -1){
            return memo[current_index][prev_index] == 1;
        }
        boolean result = false;
        for(int next_jump = prev_index - 1;next_jump <= prev_index + 1;next_jump++){
            if(next_jump > 0){
                int next_stone = stones[current_index] + next_jump;
                if(map.containsKey(next_stone)){
                    result = result || solve(map.get(next_stone),next_jump,stones,map,n,memo);
                }
            }
        }
        memo[current_index][prev_index] = result ? 1 : 0;
        return result;
    }
    public boolean canCross(int[] stones) {
        int n = stones.length;
        if(stones[1] != 1){
            return false;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i<stones.length;i++){
            map.put(stones[i],i);
        }
        int[][] memo = new int[n][n];
        for(int[] arr:memo){
            Arrays.fill(arr,-1);
        }
        return solve(0,0,stones,map,n,memo);
    }
}