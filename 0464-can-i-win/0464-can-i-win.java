class Solution {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        int sum = (maxChoosableInteger + 1) * maxChoosableInteger / 2;
        if (sum < desiredTotal) return false;
        Boolean[] memo = new Boolean[1 << maxChoosableInteger];
        return canWin(0, 0, maxChoosableInteger, desiredTotal, memo);
    }

    private boolean canWin(int used, int current, int max, int total, Boolean[] memo) {
        if (memo[used] != null) return memo[used];
        for (int i = 0; i < max; i++) {
            if ((used & (1 << i)) == 0) {
                if (current + i + 1 >= total || !canWin(used | (1 << i), current + i + 1, max, total, memo)) {
                    return memo[used] = true;
                }
            }
        }
        return memo[used] = false;
    }
}