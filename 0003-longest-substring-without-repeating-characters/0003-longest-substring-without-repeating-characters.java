class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxCount = 0;
        int j = 0;
        Set<Character> set = new HashSet<>();
        for(int i = 0;i<s.length();i++){
           while(set.contains(s.charAt(i))){
            set.remove(s.charAt(j));
            j++;
           }
           set.add(s.charAt(i));
           maxCount = Math.max(maxCount,i - j + 1);
    }
    return maxCount;
}
}