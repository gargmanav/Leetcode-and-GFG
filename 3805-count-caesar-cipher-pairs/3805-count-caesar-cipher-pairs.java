class Solution {
    public long countPairs(String[] words) {
        Map<String,Integer> map = new HashMap<>();
        for(String str : words){
            int shift = str.charAt(0) - 'a';
            StringBuilder sb = new StringBuilder();

            for(char ch : str.toCharArray()){
                char norm = (char)((ch - shift + 26 - 'a') % 26 + 'a');
                sb.append(norm);
            }
            map.put(sb.toString(), map.getOrDefault(sb.toString(), 0) + 1);
        }
        long ans = 0;
        for (int count : map.values()) {
        ans += (long) count * (count - 1) / 2;
       }

      return ans;
    }
}