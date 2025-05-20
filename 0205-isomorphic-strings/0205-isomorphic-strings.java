class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Character> mapST = new HashMap<>();
        Map<Character, Character> mapTS = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            // If c1 already mapped to something
            if (mapST.containsKey(c1)) {
                if (mapST.get(c1) != c2) return false;
            } else {
                // But before mapping, make sure c2 is not already used
                if (mapTS.containsKey(c2)) return false;

                mapST.put(c1, c2);
                mapTS.put(c2, c1);
            }
        }

        return true;
    }
}