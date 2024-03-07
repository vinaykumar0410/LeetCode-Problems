
// Tag - Medium
class Solution {
    // Initialize a pointer to keep track of the previous node.
    TreeNode prev = null; 
    
    public boolean isValidBST(TreeNode root) {
        // Recursively check the left subtree.
        if (root != null) {
            if (!isValidBST(root.left)) return false;
            
            // Check if the current node's value violates the BST property.
            if (prev != null && prev.val >= root.val) return false;
            
            // Update prev to the current node.
            prev = root; 
            
            // Recursively check the right subtree.
            if (!isValidBST(root.right)) return false;
        }

        // Return true if the tree is a valid BST.
        return true; 
    }
}
