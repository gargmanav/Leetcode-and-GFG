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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null)return result;
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        boolean flag = true;
        while(!que.isEmpty()){
            List<Integer> level = new ArrayList<>();
            int size = que.size();
            for(int i =0;i<size;i++){
                TreeNode temp = que.poll();
                if(flag){
                    level.addLast(temp.val);
                }else level.addFirst(temp.val);

                if(temp.left != null)que.add(temp.left);
                if(temp.right != null)que.add(temp.right);
            }
            result.add(level);
            flag = !flag;
        }
        return result;
    }
}