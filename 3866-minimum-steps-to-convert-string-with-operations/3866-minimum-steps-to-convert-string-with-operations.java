class Solution {
    private int minOpsToMakeSame(String s, String t) {
        int n = s.length();
        int cnt = 0;
        // Use Map to simulate multiset<pair<char,char>>
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) != t.charAt(i)) {
                String key = t.charAt(i) + "," + s.charAt(i); // complementary pair
                if (map.getOrDefault(key, 0) > 0) {
                    cnt++; // swap operation
                    map.put(key, map.get(key) - 1);
                } else {
                    String cur = s.charAt(i) + "," + t.charAt(i);
                    map.put(cur, map.getOrDefault(cur, 0) + 1);
                }
            }
        }

        int remaining = 0;
        for (int val : map.values()) remaining += val; // replace operations for remaining pairs
        return cnt + remaining;
    }

    // DP function
    private int f(int i, String s1, String s2, int[] dp) {
        int n = s1.length();
        if (i == n) return 0;
        if (dp[i] != -1) return dp[i];

        int ans = Integer.MAX_VALUE / 2; // large number
        String s = "", t = "";
        for (int j = i; j < n; j++) {
            s += s1.charAt(j);
            t += s2.charAt(j);

            // normal substring operations
            int cnt = minOpsToMakeSame(s, t);

            // reversed substring operations (+1 for reverse)
            String reversedS = new StringBuilder(s).reverse().toString();
            cnt = Math.min(cnt, 1 + minOpsToMakeSame(reversedS, t));

            ans = Math.min(ans, cnt + f(j + 1, s1, s2, dp));
        }

        dp[i] = ans;
        return ans;
    }

    public int minOperations(String word1, String word2) {
        int n = word1.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        return f(0, word1, word2, dp);
    }
}
