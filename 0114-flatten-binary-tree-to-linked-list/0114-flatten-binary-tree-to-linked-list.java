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
    private TreeNode prev = null;

    public void flatten(TreeNode root) {
        if (root == null) return;
        
        flatten(root.right); // step 1: flatten right
        flatten(root.left);  // step 2: flatten left
        
        root.right = prev;   // step 3: current node's right becomes previous node
        root.left = null;    // step 4: left is always null
        
        prev = root;         // step 5: move prev to current
    }
}
