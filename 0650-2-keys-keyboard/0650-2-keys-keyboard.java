class Solution {
    public int minSteps(int n) {
        int ans = 0;
        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                ans += i; // i steps: 1 Copy All + (i-1) Pastes
                n /= i;
            }
        }
        return ans;
    }
}