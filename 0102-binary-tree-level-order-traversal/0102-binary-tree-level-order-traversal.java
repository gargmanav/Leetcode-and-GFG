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
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        Queue<TreeNode> qe = new LinkedList<>();
        if(root == null)return res;
        qe.offer(root);
        while(!qe.isEmpty()){
            int level = qe.size();
            List<Integer> temp = new LinkedList<>();
            for(int i = 0;i<level;i++){
                if(qe.peek().left != null) qe.offer(qe.peek().left);
                if(qe.peek().right != null) qe.offer(qe.peek().right);
                temp.add(qe.poll().val);
            }
            res.add(temp);
        }
        return res;
    }
}