class Solution {
    public int longestPalindrome(String[] words) {
       Map<String, Integer> map = new HashMap<>();
        int totalLength = 0;
        int center = 0;

        for (String word : words) {
            String reversed = new StringBuilder(word).reverse().toString();
            if (map.getOrDefault(reversed, 0) > 0) {
                // Found a reverse pair
                totalLength += 4;
                map.put(reversed, map.get(reversed) - 1);
            } else {
                // Store this word for future matching
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // After pairing, check if we can place one symmetric word like "aa" in center
        for (String word : map.keySet()) {
            if (word.charAt(0) == word.charAt(1) && map.get(word) > 0) {
                totalLength += 2;
                break;  // Only one can be placed in center
            }
        }

        return totalLength; 
    }
}