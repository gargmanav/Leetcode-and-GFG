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
        // Put dictionary words into a HashSet for O(1) look‑ups.
        Set<String> dict = new HashSet<>(wordDict);
        // memo[i] = whether s[i..] can be segmented (null means "not computed yet").
        Boolean[] memo = new Boolean[s.length() + 1];
        return canBreak(0, s, dict, memo);
    }

    /**
     * Recursive helper that tries to segment the suffix starting at index <code>start</code>.
     */
    private boolean canBreak(int start, String s, Set<String> dict, Boolean[] memo) {
        // Base case: reached the end → successful segmentation.
        if (start == s.length()) {
            return true;
        }
        // Return cached result if we've solved this sub‑problem before.
        if (memo[start] != null) {
            return memo[start];
        }
        // Try every possible end index for the first word in the remaining suffix.
        for (int end = start + 1; end <= s.length(); end++) {
            // If s[start..end) is a dictionary word and the rest can be segmented → success.
            if (dict.contains(s.substring(start, end)) && canBreak(end, s, dict, memo)) {
                return memo[start] = true;
            }
        }
        // Exhausted all possibilities → cannot segment from this start index.
        return memo[start] = false;
    }
}