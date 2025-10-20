class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        
        // 1. Initial Character Counts of s
        int[] initialCounts = new int[26];
        for (char ch : s.toCharArray()) {
            initialCounts[ch - 'a']++;
        }

        // Initialize minResult to an empty string, which is lexicographically smaller than any non-empty result.
        String minResult = ""; 

        // 2. Iterate the first position 'i' where the permutation P differs from target
        // P[j] = target[j] for j < i, and P[i] > target[i]
        
        // 'counts' tracks the remaining characters of 's' after committing to matching target[0...i-1].
        int[] counts = initialCounts.clone();

        for (int i = 0; i < n; i++) {
            
            // --- A. Try to deviate at position 'i' ---
            
            // Find the smallest character 'c' > target[i] that is available in the current 'counts'.
            char targetChar = target.charAt(i);
            
            for (char c = (char)(targetChar + 1); c <= 'z'; c++) {
                int c_index = c - 'a';
                
                if (counts[c_index] > 0) {
                    // Found the smallest valid deviating character 'c' for this position 'i'.
                    
                    // 1. Construct the current result P
                    StringBuilder P = new StringBuilder();
                    
                    // a. Prefix: target[0..i-1] (already implicitly handled by the outer loop's state)
                    P.append(target.substring(0, i));
                    
                    // b. Pivot: c
                    P.append(c);
                    
                    // c. Suffix (remaining characters sorted)
                    // Temporarily decrement c's count to find the remaining characters
                    counts[c_index]--; 
                    
                    // Collect remaining characters and sort (already sorted by iterating k from 0 to 25)
                    StringBuilder suffix = new StringBuilder();
                    for (int k = 0; k < 26; k++) {
                        char remainingChar = (char)('a' + k);
                        for (int count = 0; count < counts[k]; count++) {
                            suffix.append(remainingChar);
                        }
                    }
                    P.append(suffix);
                    
                    // d. Update Minimum Result
                    String currentResult = P.toString();
                    if (minResult.isEmpty() || currentResult.compareTo(minResult) < 0) {
                        minResult = currentResult;
                    }
                    
                    // Restore c's count before breaking the 'c' loop, as we only used a copy 
                    // of 'counts' in the logic above. Wait, the 'counts' array is what 
                    // remains *after* matching target[0..i-1], so we must restore it.
                    counts[c_index]++; 
                    
                    // Optimization: Since we choose the smallest 'c' first, we don't need to check larger 'c's.
                    // The first valid result found for a fixed prefix is the smallest one starting with that prefix.
                    break; 
                }
            }

            // --- B. Commit to matching target[i] for the next iteration ---
            
            // If we didn't find a deviation (or just found and recorded one), 
            // we must now commit to matching target[i] to check for deviations at i+1.
            int target_i_index = targetChar - 'a';
            
            if (counts[target_i_index] > 0) {
                // If the character is available, use it and continue to the next position.
                counts[target_i_index]--; 
            } else {
                // Cannot match target[i]. The prefix target[0..i] is impossible.
                // Since we already checked all deviations at j <= i, and can't match 
                // target[i], no further search is needed.
                break; 
            }
        }

        return minResult;
    }
}