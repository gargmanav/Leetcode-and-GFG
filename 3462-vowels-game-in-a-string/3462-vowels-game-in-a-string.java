class Solution {
    public boolean doesAliceWin(String s) {
        int vowels = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
                vowels++;
            }
        }
        // Alice wins if there's at least one vowel
        return vowels > 0;
    }
}
