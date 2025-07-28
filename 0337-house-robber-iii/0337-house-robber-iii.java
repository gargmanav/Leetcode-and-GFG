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
    private Map<TreeNode,Integer> map;
    private int helper(TreeNode root){
       if(root == null)return 0;
       if(map.containsKey(root)){
        return map.get(root);
       }
       int take = root.val;
       if (root.left != null) take += helper(root.left.left) + helper(root.left.right);
       if (root.right != null) take += helper(root.right.left) + helper(root.right.right);
       int nottake = helper(root.left) + helper(root.right);
       int result = Math.max(take,nottake);
       map.put(root,result);
       return result;
    }
    public int rob(TreeNode root) {
        map = new HashMap<>();
        if(root == null)return 0;
        return helper(root);
    }
}