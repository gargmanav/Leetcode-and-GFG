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
    int diameter = 0;
    private int maxdiameter(TreeNode root){
        if(root == null)return 0;
        int left = maxdiameter(root.left);
        int right = maxdiameter(root.right);
        diameter = Math.max(diameter,left + right);
        return 1 +  Math.max(left ,right);
        
    }

    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null)return 0;
        maxdiameter(root);
       return diameter;
    }
}