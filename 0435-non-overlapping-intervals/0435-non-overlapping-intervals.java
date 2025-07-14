class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // Step 1: Sort intervals based on their end times (a[1] - b[1])
        Arrays.sort(intervals, (a, b) -> a[1] - b[1]);

        int count = 0; // Count of intervals to remove
        int prevEnd = intervals[0][1]; // Track the end time of the last non-overlapping interval

        // Step 2: Iterate through intervals starting from the second one
        for (int i = 1; i < intervals.length; i++) {
            // If there's an overlap
            if (intervals[i][0] < prevEnd) {
                count++; // Increment removal count
            } else {
                // Update the end time to the current interval's end
                prevEnd = intervals[i][1];
            }
        }
        return count; // Return the number of intervals removed
    }
}