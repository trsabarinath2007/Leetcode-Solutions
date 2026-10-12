import java.util.Stack;

class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        pushAllLeft(root);
    }
    
    public int next() {
        TreeNode tmpNode = stack.pop();
        // If there is a right subtree, push all its left descendants
        if (tmpNode.right != null) {
            pushAllLeft(tmpNode.right);
        }
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    private void pushAllLeft(TreeNode node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }
}