class Solution {
    public int longestStrChain(String[] words) {
        // Sort words based on length
        Arrays.sort(words, Comparator.comparingInt(String::length));
        
        Map<String, Integer> dp = new HashMap<>();
        int maxLen = 1;

        for (String word : words) {
            int best = 0;
            // Try removing one character at each position
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                int prevLen = dp.getOrDefault(prev, 0);
                best = Math.max(best, prevLen + 1);
            }
            dp.put(word, best);
            maxLen = Math.max(maxLen, best);
        }

        return maxLen;
    }
} 