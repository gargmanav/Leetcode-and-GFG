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
    public void solve(List<int[]> result,int i,int j,TreeNode root){
        if(root == null)return;
        solve(result,i + 1,j - 1,root.left);
        result.add(new int[]{i,j,root.val});
        solve(result,i + 1,j + 1,root.right);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]> result = new ArrayList<>();
        solve(result, 0, 0, root);

        // Sort by column (j), then row (i), then value
        result.sort((a, b) -> {
            if (a[1] != b[1]) return a[1] - b[1];      // j (horizontal distance)
            else if (a[0] != b[0]) return a[0] - b[0];  // i (depth)
            else return a[2] - b[2];                   // node value
        });

        List<List<Integer>> ans = new ArrayList<>();
        int prevCol = Integer.MIN_VALUE;
        List<Integer> colList = new ArrayList<>();

        for (int[] node : result) {
            int i = node[0], j = node[1], val = node[2];

            if (j != prevCol) {
                if (!colList.isEmpty()) ans.add(colList);
                colList = new ArrayList<>();
                prevCol = j;
            }
            colList.add(val);
        }

        ans.add(colList); // add last collected column
        return ans;
    }
}