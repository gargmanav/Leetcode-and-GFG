class Solution {
    private boolean isNumericallyBalanced(int num) {
        String s = String.valueOf(num);

        if (s.contains("0")) return false;
        int[] count = new int[10];
        for (char c : s.toCharArray()) {
            count[c - '0']++;
        }
        for (int d = 1; d <= 9; d++) {
            if (count[d] > 0 && count[d] != d) {
                return false;
            }
        }

        return true;
    }
    public int nextBeautifulNumber(int n) {
        int num = n + 1;
        while (true) {
            if (isNumericallyBalanced(num)) {
                return num;
            }
            num++;
        }
    }
}