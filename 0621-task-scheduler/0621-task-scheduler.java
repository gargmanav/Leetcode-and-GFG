class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for (char task : tasks) {
            freq[task - 'A']++;
        }

        // Max heap by frequency
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[1] - a[1]);
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                pq.add(new int[]{i, freq[i]});
            }
        }

        // Queue to keep track of cooldown -> {task, remainingFreq, availableTime}
        Queue<int[]> coolDown = new LinkedList<>();
        int time = 0;

        while (!pq.isEmpty() || !coolDown.isEmpty()) {
            time++;

            if (!pq.isEmpty()) {
                int[] curr = pq.poll();
                curr[1]--; // ek kaam complete
                if (curr[1] > 0) {
                    // available again after n units
                    coolDown.add(new int[]{curr[0], curr[1], time + n});
                }
            }

            // Check if front of cooldown is ready
            if (!coolDown.isEmpty() && coolDown.peek()[2] == time) {
                int[] ready = coolDown.poll();
                pq.add(new int[]{ready[0], ready[1]});
            }
        }

        return time;
    }
}
