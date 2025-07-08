class Solution {
    private String sortString(String str){
        char[] s = str.toCharArray();
        Arrays.sort(s);
        return new String(s);
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> map = new HashMap<>();
        for(int i = 0;i<strs.length;i++){
            String s = sortString(strs[i]);
            map.computeIfAbsent(s,k->new ArrayList<>()).add(strs[i]);
        }
       List<List<String>> result = new ArrayList<>(map.values());
       return result;
    }
}