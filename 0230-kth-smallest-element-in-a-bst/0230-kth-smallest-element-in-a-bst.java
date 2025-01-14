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
    private void solve(TreeNode root,List<Integer> li){
        if(root == null)return;
        li.add(root.val);
        solve(root.left,li);
        solve(root.right,li);
       
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> li = new ArrayList<>();
        solve(root,li);
        Collections.sort(li);
        return li.get(k - 1);
    }
}