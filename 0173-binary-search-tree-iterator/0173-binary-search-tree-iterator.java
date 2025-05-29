class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushLeftNodes(root); // Initialize by pushing all left nodes from root
    }

    // Returns the next smallest number
    public int next() {
        TreeNode node = stack.pop(); // top of stack is the next smallest element
        if (node.right != null) {
            pushLeftNodes(node.right); // if right child exists, push its leftmost subtree
        }
        return node.val;
    }

    // Returns whether we have a next smallest number
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    // Helper function to push all left nodes of a subtree
    private void pushLeftNodes(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}