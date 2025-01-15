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
    private TreeNode solve(int[] nums,int begin,int end){
       if(begin > end){
        return null;
       }
       int mid = (begin + end)/2;
       TreeNode root = new TreeNode(nums[mid]);
       root.left = solve(nums,begin,mid - 1);
       root.right = solve(nums,mid + 1,end);
       return root;
    }
    public TreeNode sortedArrayToBST(int[] nums) {
        return solve(nums,0,nums.length - 1);
    }
}