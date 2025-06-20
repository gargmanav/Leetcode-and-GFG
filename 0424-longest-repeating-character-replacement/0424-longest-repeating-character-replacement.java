class Solution {
    public int characterReplacement(String s, int k) {
        int[] count = new int[26];
        int max = 0;
        int left = 0;
        int result = 0;
        for(int right = 0;right < s.length();right++){
            count[s.charAt(right) - 'A']++;
            max = Math.max(max,count[s.charAt(right)- 'A']);
            int window_size = right - left + 1;
            if(window_size - max > k){
                count[s.charAt(left) - 'A']--;
                left++;
            }
            result = Math.max(result,right - left + 1);
        }
        return result;
    }
}