
// Tag - Medium
class BSTIterator {

    Stack<TreeNode> stack; // Stack to store nodes
    TreeNode curr; // Current node

    public BSTIterator(TreeNode root) {
        stack = new Stack(); // Initialize stack
        curr = root; // Set current node to the root
    }

    public int next() {
        // Traverse left subtree and push nodes onto stack
        while (curr != null) {
            stack.push(curr);
            curr = curr.left;
        }

        // Pop the top node from the stack (which will be the smallest)
        TreeNode next = stack.pop();

        // Move to the right subtree of the popped node
        curr = next.right;

        // Return the value of the popped node
        return next.val;
    }

    public boolean hasNext() {
        // If stack is not empty or current node is not null, there's a next element
        return !stack.isEmpty() || curr != null;
    }
}
