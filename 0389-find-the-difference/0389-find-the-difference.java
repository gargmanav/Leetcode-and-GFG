class Solution {
    public char findTheDifference(String s, String t) {
        int stotal = s.chars().map(c -> c - 'a' + 1).sum();
        int ttotal = t.chars().map(c -> c - 'a' + 1).sum();
        int diff = ttotal - stotal;

        return (char)('a' + diff - 1);
    }
}