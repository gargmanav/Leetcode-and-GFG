class Solution {
    public int[][] merge(int[][] intervals) {
         // Step 1: Sort intervals based on the start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> merged = new ArrayList<>();

        for (int[] interval : intervals) {
            // If merged is empty or no overlap
            if (merged.isEmpty() || merged.get(merged.size() - 1)[1] < interval[0]) {
                merged.add(interval);
            } else {
                // Overlap detected, merge the intervals
                merged.get(merged.size() - 1)[1] = Math.max(
                    merged.get(merged.size() - 1)[1], interval[1]
                );
            }
        }

        // Convert list to array and return
        return merged.toArray(new int[merged.size()][]);
    }
}