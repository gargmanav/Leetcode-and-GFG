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
    
    private void inOrder(TreeNode root,int low,int high,AtomicInteger sum){
        if(root != null){
            inOrder(root.left,low,high,sum);
            int val = root.val;
            if(val >= low && val <= high){
                sum.addAndGet(val);
            }
            inOrder(root.right,low,high,sum);
        }
    }
    public int rangeSumBST(TreeNode root, int low, int high) {
        AtomicInteger sum = new AtomicInteger(0);
        inOrder(root,low,high,sum);
        return sum.get();
    }
}