class Solution {
    class Pair {
        int amount, steps;
        Pair(int amount, int steps) {
            this.amount = amount;
            this.steps = steps;
        }
    }

    public int coinChange(int[] coins, int amount) {
        if (amount < 0) return -1;
        if (amount == 0) return 0;

        Queue<Pair> que = new LinkedList<>();
        que.add(new Pair(0, 0));

        boolean[] visited = new boolean[amount + 1];
        visited[0] = true;

        while (!que.isEmpty()) {
            Pair curr = que.poll();

            if (curr.amount == amount) return curr.steps;

            for (int coin : coins) {
                if (curr.amount <= amount - coin) {
    int newsum = curr.amount + coin;
    if (!visited[newsum]) {
        que.add(new Pair(newsum, curr.steps + 1));
        visited[newsum] = true;
    }
}
            }
        }

        return -1;
    }
}
