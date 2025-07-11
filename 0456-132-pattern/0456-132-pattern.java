import java.util.*;

class Solution {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3) return false;

        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE; // this is the potential nums[k]

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] < third) {
                return true; // nums[i] is the 1 in the 132 pattern
            }

            while (!stack.isEmpty() && nums[i] > stack.peek()) {
                third = stack.pop(); // update nums[k]
            }

            stack.push(nums[i]); // potential nums[j]
        }

        return false;
    }
}
