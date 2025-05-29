class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        // Initialize result with -1
        Arrays.fill(result, -1);

        // Traverse the array twice (simulate circular array)
        for (int i = 2 * n - 1; i >= 0; i--) {
            int current = nums[i % n];
            
            // Pop elements that are less than or equal to current
            while (!stack.isEmpty() && nums[stack.peek()] <= current) {
                stack.pop();
            }

            // Fill result only for first n elements
            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = nums[stack.peek()];
                }
            }

            // Push current index
            stack.push(i % n);
        }

        return result;
    }
}