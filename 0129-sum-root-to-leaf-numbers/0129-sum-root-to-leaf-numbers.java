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
    int Totalsum = 0;
    private int sumRoot(TreeNode root,int currentSum){
       if (root == null) return 0; // Base case
        
        currentSum = currentSum * 10 + root.val; // Update the sum for the current path
        
        // If it's a leaf node, return the computed sum
        if (root.left == null && root.right == null) {
            return currentSum;
        }
        
        // Sum of left and right subtrees
        int leftSum = sumRoot(root.left, currentSum);
        int rightSum = sumRoot(root.right, currentSum);
        
        return leftSum + rightSum;
    }
    public int sumNumbers(TreeNode root) {
       if(root == null)return 0;
       return sumRoot(root,0);
    }
}