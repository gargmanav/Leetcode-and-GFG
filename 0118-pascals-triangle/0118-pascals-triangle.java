class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Arrays.asList(1));
        for(int i = 1;i<numRows;i++){
            List<Integer> temp = new ArrayList<>();
            for(int j = 0;j <= i;j++){
                if(j == 0 || j == i){
                    temp.add(1);
                }else{
                    temp.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
                if(temp.size() == i + 1){
                    result.add(temp);
                }
            }
        }
        return result;
    }
}