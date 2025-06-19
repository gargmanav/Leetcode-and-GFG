class Solution {
    public int sumOddLengthSubarrays(int[] arr) {
        int n = arr.length;
        int total = 0;

        for (int i = 0; i < n; i++) {
            int start = i + 1;
            int end = n - i;
            int totalSubarrays = start * end;

            int oddCount = totalSubarrays / 2;
            if (totalSubarrays % 2 == 1) {
                oddCount++;
            }

            total += arr[i] * oddCount;
        }

        return total;
    }
}