class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);

        int level = 1; // beginWord is level 1

        while (!queue.isEmpty()) {
            int size = queue.size(); // current level size

            for (int i = 0; i < size; i++) {
                String word = queue.poll();

                // Generate all possible words by changing one letter at a time
                char[] chars = word.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char originalChar = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == originalChar) continue;
                        chars[j] = c;
                        String newWord = new String(chars);
                        if (newWord.equals(endWord)) {
                            return level + 1;
                        }
                        if (wordSet.contains(newWord)) {
                            queue.offer(newWord);
                            wordSet.remove(newWord); // avoid revisiting
                        }
                    }
                    chars[j] = originalChar; // restore
                }
            }

            level++;
        }

        return 0; // no path found
    }
}