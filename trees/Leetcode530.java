
// Tag - Easy
class Solution {
    // Initialize the minimum difference variable.
    int min = Integer.MAX_VALUE; 
    // Initialize a pointer to keep track of the previous node.
    TreeNode prev = null; 
    
    public int getMinimumDifference(TreeNode root) {
        if (root != null) {
            // Recursively traverse left subtree.
            getMinimumDifference(root.left); 
            
            // If prev is not null, calculate the difference with the current node.
            if (prev != null) min = Math.min(min, Math.abs(prev.val - root.val));
            
            // Update prev to the current node.
            prev = root; 

            // Recursively traverse right subtree.
            getMinimumDifference(root.right); 
        }

        // Return the minimum difference found.
        return min; 
    }
}
