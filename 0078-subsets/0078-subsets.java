class Solution {
   public static void findsubset(int i,int[] nums,int n,List<Integer> current,List<List<Integer>> result){
    if (i == n) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element and move to the next
        findsubset(i + 1, nums, n, current, result);

        // Include the current element and move to the next
        current.add(nums[i]);
        findsubset(i + 1, nums, n, current, result);
        current.remove(current.size() - 1);
   }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findsubset(0,nums,nums.length,new ArrayList<>(),result);
        return result;
    }
}