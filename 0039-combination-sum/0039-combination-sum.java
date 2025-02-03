class Solution {
    private void recursion(int index,List<List<Integer>> result,List<Integer> ds,int sum,int[] candidates, int target){
            
            if(sum == target){
               result.add(new ArrayList<>(ds));
               return;
            }
            if(sum > target || candidates.length == index){
                return;
            }
        ds.add(candidates[index]);
       
        recursion(index, result, ds, sum + candidates[index], candidates, target);
        ds.remove(ds.size() - 1);
        recursion(index + 1,result,ds,sum,candidates,target);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        int sum = 0;
        recursion(0,result,ds,sum,candidates,target);
        return result;
    }
}