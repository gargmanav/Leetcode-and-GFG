class Solution {
    public int findLongestChain(int[][] pairs) {
        int n = pairs.length;
        Arrays.sort(pairs,(a,b) -> Integer.compare(a[1],b[1]));
        int count = 1;
        int i = 0;

        for (int j = 1; j < n; j++) {
            if (pairs[i][1] < pairs[j][0]) {
                count++;
                i = j;
            }
        }
        return count;
    }
}