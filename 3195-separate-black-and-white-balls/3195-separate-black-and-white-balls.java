class Solution {
    public long minimumSteps(String s) {
        long steps = 0;
        long whiteCount = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                whiteCount++;
            } else { // it's a black ball
                steps += whiteCount;
            }
        }

        return steps;
    }
}
