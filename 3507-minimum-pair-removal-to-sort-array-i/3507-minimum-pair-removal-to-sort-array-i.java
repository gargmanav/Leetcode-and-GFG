class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int n : nums) {
            list.add(n);
        }
        int count = 0;
        while(!isNonDecreasoning(list)){
          int first = 0,second =1,minsum = list.get(0) + list.get(1);
          for(int j = 2;j < list.size();j++){
             int sum = list.get(j - 1) + list.get(j);
             if(sum < minsum){
                 first = j - 1;
                 second = j;
                 minsum = list.get(j - 1) + list.get(j);
             }
          }
          list.set(first,minsum);
          list.remove(second);
          count++;
        }
        return count;
    }
   public boolean isNonDecreasoning(List<Integer> list){
    for (int i = 1; i < list.size(); i++) {
            if (list.get(i) < list.get(i - 1)) {
                return false;
            }
        }
        return true;
   }
}