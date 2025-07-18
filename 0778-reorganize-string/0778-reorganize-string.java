import java.util.*;

class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        for (char c : s.toCharArray()) {
            count[c - 'a']++;
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> count[b - 'a'] - count[a - 'a']);
        for (char c = 'a'; c <= 'z'; c++) {
            if (count[c - 'a'] > 0) {
                if (count[c - 'a'] > (s.length() + 1) / 2) return ""; // impossible
                maxHeap.add(c);
            }
        }

        StringBuilder result = new StringBuilder();
        while (maxHeap.size() >= 2) {
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            result.append(first);
            result.append(second);
            count[first - 'a']--;
            count[second - 'a']--;

            if (count[first - 'a'] > 0) maxHeap.add(first);
            if (count[second - 'a'] > 0) maxHeap.add(second);
        }

        if (!maxHeap.isEmpty()) result.append(maxHeap.poll()); // last character if any

        return result.toString();
    }
}
