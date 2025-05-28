class Solution {
    public String[] findRelativeRanks(int[] score) {
        ArrayList<int[]> pq = new ArrayList<>();
        
        // Store score and original index
        for (int i = 0; i < score.length; i++) {
            pq.add(new int[]{score[i], i});
        }

        // Sort by score descending
        pq.sort((a, b) -> b[0] - a[0]);

        // Assign ranks (modify the score field to store rank)
        for (int i = 0; i < score.length; i++) {
            pq.get(i)[0] = i + 1; // Rank starts from 1
        }

        // Sort back by original index to maintain input order
        pq.sort((a, b) -> a[1] - b[1]);

        // Prepare result array
        String[] res = new String[score.length];
        for (int i = 0; i < score.length; i++) {
            int rank = pq.get(i)[0];
            if (rank == 1) {
                res[i] = "Gold Medal";
            } else if (rank == 2) {
                res[i] = "Silver Medal";
            } else if (rank == 3) {
                res[i] = "Bronze Medal";
            } else {
                res[i] = Integer.toString(rank);
            }
        }

        return res;
    }
}