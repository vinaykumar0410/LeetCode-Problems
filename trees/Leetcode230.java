
// Tag - Medium
class Solution {
    // Initialize the result variable to store the kth smallest element.
    int result = -1;
    // Initialize the index counter to track the current position. 
    int index = 0; 
    
    public int kthSmallest(TreeNode root, int k) {
        // Call the helper method to traverse the tree and find the kth smallest element.
        helper(root, k); 
        // Return the result.
        return result; 
    }
    
    // Helper method to perform in-order traversal and find the kth smallest element.
    private void helper(TreeNode root, int k) {
        if (root != null) {
            // Recursively traverse left subtree.
            helper(root.left, k); 

            index++; // Increment the index counter.
            if (index == k) // If the current index matches k, store the value as result.
                result = root.val;

            // Recursively traverse right subtree.
            helper(root.right, k); 
        }
    }
}
