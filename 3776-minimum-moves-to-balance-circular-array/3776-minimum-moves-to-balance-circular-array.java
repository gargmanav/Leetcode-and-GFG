class Solution {
    public long minMoves(int[] balance) {
        int n = balance.length;

        long sum = 0;
        int index = -1;

        // sum + negative index
        for (int i = 0; i < n; i++) {
            sum += balance[i];
            if (balance[i] < 0) {
                index = i;
            }
        }

        if (sum < 0) return -1;
        if (index == -1) return 0;

        long need = -balance[index];
        long moves = 0;
        int dist = 1;

        while (need > 0) {
            int left = (index - dist + n) % n;
            int right = (index + dist) % n;

            if (balance[left] > 0) {
                long take = Math.min(balance[left], need);
                moves += take * dist;
                need -= take;
                balance[left] -= take;
            }

            if (need > 0 && balance[right] > 0) {
                long take = Math.min(balance[right], need);
                moves += take * dist;
                need -= take;
                balance[right] -= take;
            }

            dist++;
        }

        return moves;
    }
}
