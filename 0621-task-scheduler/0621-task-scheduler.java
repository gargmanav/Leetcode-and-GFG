class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];

        // Step 1: Count frequency of each task
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Step 2: Find the maximum frequency
        Arrays.sort(freq);
        int maxFreq = freq[25];

        // Step 3: Count how many tasks have this max frequency
        int countMaxFreq = 1;
        for (int i = 24; i >= 0; i--) {
            if (freq[i] != maxFreq) break;
            countMaxFreq++;
        }

        // Step 4: Apply the formula
        int partCount = maxFreq - 1;
        int partLength = n + 1;
        int emptySlots = partCount * partLength + countMaxFreq;

        // Step 5: Final answer is max of calculated time and total tasks
        return Math.max(emptySlots, tasks.length);
    }
}