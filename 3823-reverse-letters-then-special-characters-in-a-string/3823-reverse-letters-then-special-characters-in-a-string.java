class Solution {
    public String reverseByType(String s) {
        int n = s.length();
        char[] result = new char[n];

        StringBuilder letters = new StringBuilder();
        StringBuilder specials = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c >= 'a' && c <= 'z') {
                letters.append(c);
            } else {
                specials.append(c);
            }
        }
        letters.reverse();
        specials.reverse();
        int l = 0, sp = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c >= 'a' && c <= 'z') {
                result[i] = letters.charAt(l++);
            } else {
                result[i] = specials.charAt(sp++);
            }
        }

        return new String(result);
    }
}
