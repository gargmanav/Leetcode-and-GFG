class Solution {
    private int findlowerbound(int target, int[][] intervals) {
        int rows = intervals.length;
        int left = 0;
        int right = rows * 2;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int row = mid / 2;
            int col = mid % 2;

            if (intervals[row][col] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left / 2; // row index
    }

    private int findupperbound(int target, int[][] intervals) {
        int rows = intervals.length;
        int left = 0;
        int right = rows * 2;

        while (left < right) {
            int mid = left + (right - left) / 2;
            int row = mid / 2;
            int col = mid % 2;

            if (intervals[row][col] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left / 2; // row index
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> temp = new ArrayList<>();

        int left = findlowerbound(newInterval[0], intervals);
        int right = left;

        // instead of relying on upperbound, merge till overlap manually
        int s = newInterval[0];
        int e = newInterval[1];

        // 1. Add intervals before merge starts
        int i = 0;
        while (i < left) {
            temp.add(intervals[i]);
            i++;
        }

        // 2. Merge all overlapping intervals (check if start <= e)
        while (i < intervals.length && intervals[i][0] <= e) {
            s = Math.min(s, intervals[i][0]);
            e = Math.max(e, intervals[i][1]);
            i++;
        }

        temp.add(new int[]{s, e});

        // 3. Add rest of intervals
        while (i < intervals.length) {
            temp.add(intervals[i]);
            i++;
        }

        // 4. Convert to array
        int[][] res = new int[temp.size()][2];
        for (int k = 0; k < temp.size(); k++) {
            res[k][0] = temp.get(k)[0];
            res[k][1] = temp.get(k)[1];
        }

        return res;
    }
}
