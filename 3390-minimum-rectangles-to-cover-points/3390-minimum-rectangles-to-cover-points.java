class Solution {
    public int minRectanglesToCoverPoints(int[][] points, int w) {
          // Sort points by x-coordinate
        Arrays.sort(points, (a, b) -> Integer.compare(a[0], b[0]));

        int count = 0;
        int i = 0;
        int n = points.length;

        while (i < n) {
            int start = points[i][0]; // Start of rectangle
            count++;

            // Skip all points within [start, start + w]
            while (i < n && points[i][0] <= start + w) {
                i++;
            }
        }

        return count;
    }
}