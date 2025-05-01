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
        public int pathSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        // Count paths starting at current root
        return countFromNode(root, 0, targetSum)
             + pathSum(root.left, targetSum)
             + pathSum(root.right, targetSum);
    }

    private int countFromNode(TreeNode node, long currentSum, int targetSum) {
        if (node == null) return 0;

        currentSum += node.val;
        int count = (currentSum == targetSum) ? 1 : 0;

        count += countFromNode(node.left, currentSum, targetSum);
        count += countFromNode(node.right, currentSum, targetSum);

        return count;
    }
}