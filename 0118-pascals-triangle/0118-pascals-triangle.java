class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for(int i = 0;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j<=i;j++){
               if(j == 0 || j == i){
                temp.add(1);
               }else{
                int value = result.get(i-1).get(j-1) + result.get(i-1).get(j);
                temp.add(value);
               }
            }
            result.add(temp);
        }
        return result;
    }
}