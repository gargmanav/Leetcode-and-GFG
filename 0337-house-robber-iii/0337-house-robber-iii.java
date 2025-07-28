/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int rob(TreeNode root) {
        int[] result = helper(root);
        return Math.max(result[0], result[1]);
    }

    private int[] helper(TreeNode node) {
        if (node == null) return new int[2];

        int[] left = helper(node.left);
        int[] right = helper(node.right);

        int robThis = node.val + left[1] + right[1]; // Rob current: cannot rob children
        int notRobThis = Math.max(left[0], left[1]) + Math.max(right[0], right[1]); // Not rob current: choose best from children

        return new int[]{robThis, notRobThis};
    }
}
