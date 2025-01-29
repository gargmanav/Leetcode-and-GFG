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
    private void inOrderTraversal(TreeNode root,List<Integer> list){
        if(root != null){
            inOrderTraversal(root.left,list);
            list.add(root.val);
            inOrderTraversal(root.right,list);
        }
    }

    private void mergeList(List<Integer> mergeList,List<Integer> list1,List<Integer> list2){
        int i = 0,j = 0;
        while(i < list1.size() && j < list2.size()){
            if(list1.get(i) < list2.get(j)){
                mergeList.add(list1.get(i));
                i++;
            }else{
                mergeList.add(list2.get(j));
                j++;
            }
        }
        while(i < list1.size()){
            mergeList.add(list1.get(i));
            i++;
        }
        while(j < list2.size()){
            mergeList.add(list2.get(j));
            j++;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        
        inOrderTraversal(root1,list1);
        inOrderTraversal(root2,list2);
        List<Integer> mergeList = new ArrayList<>();
        mergeList(mergeList,list1,list2);
        return mergeList;
    }
}