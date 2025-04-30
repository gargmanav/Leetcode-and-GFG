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
    public void isPathSum(TreeNode root,int targetSum,int currentSum,List<List<Integer>> result,List<Integer> current){
        if (root == null) return;

        currentSum += root.val;
        current.add(root.val);

        // Check for leaf node and if the path sum matches
        if (root.left == null && root.right == null && currentSum == targetSum) {
            result.add(new ArrayList<>(current)); // add a copy of current path
        } else {
            isPathSum(root.left, targetSum, currentSum, result, current);
            isPathSum(root.right, targetSum, currentSum, result, current);
        }

        current.remove(current.size() - 1); // backtrack
    }
    
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> current = new ArrayList<>();
        isPathSum(root,targetSum,0,result,current);
        return result;
    }
}