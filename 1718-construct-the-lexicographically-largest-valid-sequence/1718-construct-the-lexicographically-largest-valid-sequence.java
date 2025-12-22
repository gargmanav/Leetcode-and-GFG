import java.util.*;

class Solution {
    public int[] constructDistancedSequence(int n) {
        int size = 2 * n - 1;
        int[] ans = new int[size];
        boolean[] used = new boolean[n + 1]; // Using boolean array for faster lookup than Set
        
        solve(0, n, size, ans, used);
        return ans;
    }

    private boolean solve(int idx, int n, int size, int[] ans, boolean[] used) {
        // Find the next empty slot
        while (idx < size && ans[idx] != 0) {
            idx++;
        }

        // If we reached the end, the sequence is complete
        if (idx >= size) {
            return true;
        }

        // Try placing numbers from n down to 1 (to ensure lexicographical largest)
        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;

            if (i == 1) {
                ans[idx] = 1;
                used[1] = true;
                if (solve(idx + 1, n, size, ans, used)) return true;
                // Backtrack
                ans[idx] = 0;
                used[1] = false;
            } else {
                // Check if the second position for number 'i' is within bounds and empty
                if (idx + i < size && ans[idx + i] == 0) {
                    ans[idx] = i;
                    ans[idx + i] = i;
                    used[i] = true;
                    
                    if (solve(idx + 1, n, size, ans, used)) return true;
                    
                    // Backtrack
                    ans[idx] = 0;
                    ans[idx + i] = 0;
                    used[i] = false;
                }
            }
        }
        return false;
    }
}