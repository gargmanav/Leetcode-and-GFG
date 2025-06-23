class Solution {
    public long kMirror(int k, int n) {
        long sum = 0;
        int count = 0;
        int len = 1;

        while (count < n) {
            // Odd length palindromes
            for (long half = (long)Math.pow(10, len - 1); half < (long)Math.pow(10, len); half++) {
                StringBuilder sb = new StringBuilder();
                sb.append(half);
                String rev = sb.reverse().substring(1); // omit middle digit for odd
                sb.reverse().append(rev);
                long num = Long.parseLong(sb.toString());

                if (isPalindrome(Long.toString(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }

            // Even length palindromes
            for (long half = (long)Math.pow(10, len - 1); half < (long)Math.pow(10, len); half++) {
                StringBuilder sb = new StringBuilder();
                sb.append(half);
                String rev = sb.reverse().toString();
                sb.reverse().append(rev);  // full mirror
                long num = Long.parseLong(sb.toString());

                if (isPalindrome(Long.toString(num, k))) {
                    sum += num;
                    count++;
                    if (count == n) return sum;
                }
            }

            len++;
        }

        return sum;
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l++) != s.charAt(r--)) return false;
        }
        return true;
    }
}
