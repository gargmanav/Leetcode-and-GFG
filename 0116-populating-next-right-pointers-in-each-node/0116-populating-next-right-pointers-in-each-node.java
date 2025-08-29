class Solution {
    public Node connect(Node root) {
        if (root == null) return null;
        connectNodes(root.left, root.right);
        return root;
    }
    
    private void connectNodes(Node left, Node right) {
        if (left == null || right == null) return;
        
        // Connect the two nodes
        left.next = right;
        
        // Connect children of the same parent
        connectNodes(left.left, left.right);
        connectNodes(right.left, right.right);
        
        // Connect across parents
        connectNodes(left.right, right.left);
    }
}
