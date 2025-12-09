class Solution {
    public long totalScore(int hp, int[] damage, int[] requirement) {
        int n = damage.length;
        // prefix sum in long to be safe
        long[] pref = new long[n];
        pref[0] = damage[0];
        for (int i = 1; i < n; i++) {
            pref[i] = pref[i - 1] + damage[i];
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {              // start from 0; no special-case needed
            int boundary = find(pref, i, hp, requirement);
            if (boundary <= i) {
                ans += (long)(i - boundary + 1);   // count of valid starts
            }
        }
        return ans;
    }

    // pref is long[] (prefix sums)
    // returns smallest j in [0..idx] such that hp - sum(j..idx) >= req
    // returns idx+1 if none satisfy
    public int find(long[] pref, int idx, int hp, int[] requirement) {
        int lo = 0;
        int hi = idx + 1; // search range [0, idx+1) so we can return idx+1 meaning "none true"

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            long healthLost = pref[idx] - (mid > 0 ? pref[mid - 1] : 0L);
            long remaining = (long)hp - healthLost;

            if (remaining >= requirement[idx]) {
                // predicate TRUE -> try find an earlier true (move left)
                hi = mid;
            } else {
                // FALSE -> move right
                lo = mid + 1;
            }
        }
        return lo; // lo == first true index or idx+1 if none
    }
}
