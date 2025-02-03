class Solution {
    private void recursion(int index,List<List<Integer>> result,List<Integer> ds,int sum,int[] candidates, int target){
            
            if(sum == target){
               result.add(new ArrayList<>(ds));
               return;
            }
            if(sum > target){
                return;
            }
            for(int i = index;i<candidates.length;i++){
            if(index < i && candidates[i] == candidates[i - 1])continue;
        ds.add(candidates[i]);
        recursion(i + 1, result, ds, sum + candidates[i], candidates, target);
        ds.remove(ds.size() - 1);
                }
        
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
         List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] flag = new boolean[candidates.length];
        int sum = 0;
        Arrays.sort(candidates);
        recursion(0,result,ds,sum,candidates,target);
        return result;
    }
}