class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return Math.max(
            getMax(answerKey, k, 'T'),
            getMax(answerKey, k, 'F')
        );
    }

    private int getMax(String s, int k, char ch) {
        int left = 0, maxLen = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            if (s.charAt(right) != ch) {
                count++; // need a flip
            }

            while (count > k) {
                if (s.charAt(left) != ch) {
                    count--; // shrink window
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }
}