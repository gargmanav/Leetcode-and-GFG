class Solution {
    public long countDistinct(long n) {
        String num = Long.toString(n);
        int len = num.length();
        long sum = 0;

        for (int digits = 1; digits < len; digits++) {
            sum += (long)Math.pow(9, digits);
        }

        for (int i = 0; i < len; i++) {
            int d = num.charAt(i) - '0';

            if (d == 0) {
                return sum;
            }

            sum += (long)(d - 1) * Math.pow(9, len - i - 1);
        }
        return sum + 1;
    }
}
