class Solution {
    private String sortString(String str){
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return new String(s);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String s = sortString(strs[i]);
            if(!map.containsKey(s)){
                map.put(s,new ArrayList<>());
            }
            map.get(s).add(i);
        }
       List<List<String>> result = new ArrayList<>();
       for(List<Integer> temp : map.values()){
        int n = temp.size();
        List<String> inner = new ArrayList<>();
        for(int i : temp){
            inner.add(strs[i]);
        }
        result.add(inner);
       }
       return result;
    }
}