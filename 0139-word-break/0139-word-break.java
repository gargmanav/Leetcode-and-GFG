import java.util.*;

class Solution {
    /**
     * Determines if the input string can be segmented into a sequence of one or more
     * dictionary words.
     *
     * Time Complexity: O(n²), where n is the length of s (two nested loops)
     * Space Complexity: O(n) for the dp array plus O(|wordDict|) for the hash set.
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        // Convert the dictionary to a HashSet for O(1) look‑ups.
        Set<String> set = new HashSet<>(wordDict);

        int n = s.length();
        // dp[i] is true if s[0..i) can be segmented into dictionary words.
        boolean[] dp = new boolean[n + 1];
        dp[0] = true; // empty string is segmentable by definition

        // Iterate over all prefixes of s.
        for (int i = 1; i <= n; i++) {
            // Try every possible split point j in the prefix s[0..i)
            for (int j = 0; j < i; j++) {
                // If s[0..j) is segmentable and s[j..i) is in the dict -> s[0..i) is segmentable
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break; // early exit for current i once we find a valid split
                }
            }
        }

        return dp[n]; // answer for the whole string
    }
}