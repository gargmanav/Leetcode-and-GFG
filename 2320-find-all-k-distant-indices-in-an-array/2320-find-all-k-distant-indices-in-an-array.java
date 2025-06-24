class Solution {
    public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
        List<Integer> keyIndices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == key) {
                keyIndices.add(i);
            }
        }

        Set<Integer> resultSet = new HashSet<>();
        for (int index : keyIndices) {
            int start = Math.max(0, index - k);
            int end = Math.min(nums.length - 1, index + k);
            for (int i = start; i <= end; i++) {
                resultSet.add(i);
            }
        }

        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        return result;
    }
}