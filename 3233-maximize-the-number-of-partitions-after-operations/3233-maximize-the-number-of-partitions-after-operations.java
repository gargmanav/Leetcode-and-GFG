import java.util.*;

class Solution {
    String S;
    int K;
    int n;
    Map<String, Integer> memo;

    public int solve(int index, int mask, boolean canChange) {
        // Base case
        if (index == n) return 0;

        // Memo key (since canChange can be 0 or 1)
        String key = index + "," + mask + "," + (canChange ? 1 : 0);
        if (memo.containsKey(key)) return memo.get(key);

        int currChar = S.charAt(index) - 'a';
        int newMask = mask | (1 << currChar);
        int setBits = Integer.bitCount(newMask);

        int result = 0;
        // Option 1: continue same partition or start new one
        if (setBits > K) {
            // new partition
            result = 1 + solve(index + 1, (1 << currChar), canChange);
        } else {
            result = solve(index + 1, newMask, canChange);
        }

        // Option 2: change this character (only if canChange == true)
        if (canChange) {
            for (int i = 0; i < 26; i++) {
                if (i == currChar) continue; // skip same char
                int changedMask = mask | (1 << i);
                int bits = Integer.bitCount(changedMask);

                if (bits > K) {
                    // start new partition after change
                    result = Math.max(result, 1 + solve(index + 1, (1 << i), false));
                } else {
                    result = Math.max(result, solve(index + 1, changedMask, false));
                }
            }
        }

        memo.put(key, result);
        return result;
    }

    public int maxPartitionsAfterOperations(String s, int k) {
        S = s;
        K = k;
        n = s.length();
        memo = new HashMap<>();

        // +1 because last partition also counts
        return solve(0, 0, true) + 1;
    }
}
