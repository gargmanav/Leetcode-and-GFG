class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0;  // Count of unmatched '('
        int close = 0; // Count of unmatched ')'

        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                open++;
            } else { // ch == ')'
                if (open > 0) {
                    open--; // Match with a previous '('
                } else {
                    close++; // Need to add one '('
                }
            }
        }

        // Total insertions needed = unmatched '(' + unmatched ')'
        return open + close;
    }
}
