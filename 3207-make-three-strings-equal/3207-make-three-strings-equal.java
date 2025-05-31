class Solution {
    public int findMinimumOperations(String s1, String s2, String s3) {
        int minLength = Math.min(s1.length(), Math.min(s2.length(), s3.length()));
        int i = 0;
        
        // Find the longest common prefix
        while (i < minLength && s1.charAt(i) == s2.charAt(i) && s2.charAt(i) == s3.charAt(i)) {
            i++;
        }
        
        // If no common prefix exists
        if (i == 0) return -1;
        
        // Total operations = characters trimmed from each string
        return (s1.length() - i) + (s2.length() - i) + (s3.length() - i);
    }
}