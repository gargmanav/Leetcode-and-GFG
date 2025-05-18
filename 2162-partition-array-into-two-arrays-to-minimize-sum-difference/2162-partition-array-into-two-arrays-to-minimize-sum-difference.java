class Solution {
    public int minimumDifference(int[] nums) {
        int n = nums.length / 2;
        int totalSum = 0;
        for (int num : nums) totalSum += num;

        int[] left = Arrays.copyOfRange(nums, 0, n);
        int[] right = Arrays.copyOfRange(nums, n, nums.length);

        Map<Integer, List<Integer>> leftMap = new HashMap<>();
        Map<Integer, List<Integer>> rightMap = new HashMap<>();

        generateSums(left, 0, 0, 0, leftMap);
        generateSums(right, 0, 0, 0, rightMap);

        int minDiff = Integer.MAX_VALUE;

        for (int i = 0; i <= n; i++) {
            List<Integer> leftSums = leftMap.get(i);
            List<Integer> rightSums = rightMap.get(n - i);

            Collections.sort(rightSums); // for binary search

            for (int lSum : leftSums) {
                int target = totalSum / 2 - lSum;
                int idx = Collections.binarySearch(rightSums, target);

                if (idx < 0) idx = -idx - 1;

                // check current and one before for closest
                for (int j = Math.max(0, idx - 1); j <= Math.min(idx, rightSums.size() - 1); j++) {
                    int rSum = rightSums.get(j);
                    int currSum = lSum + rSum;
                    int otherSum = totalSum - currSum;
                    minDiff = Math.min(minDiff, Math.abs(currSum - otherSum));
                }
            }
        }

        return minDiff;
    }

    private void generateSums(int[] arr, int index, int count, int sum,
                              Map<Integer, List<Integer>> map) {
        if (index == arr.length) {
            map.computeIfAbsent(count, k -> new ArrayList<>()).add(sum);
            return;
        }

        // don't pick current
        generateSums(arr, index + 1, count, sum, map);

        // pick current
        generateSums(arr, index + 1, count + 1, sum + arr[index], map);
    }
}