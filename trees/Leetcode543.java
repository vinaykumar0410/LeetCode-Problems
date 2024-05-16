
// Tag - Easy
class Solution {
    // Initialize the diameter of the binary tree.
    int diameter = 0; 
    
    // Calculates the diameter of the binary tree.
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0; // If the tree is empty, diameter is 0.
        // Call helper function to calculate diameter.
        helper(root); 
        return diameter; // Return the diameter of the binary tree.
    }
    
    int helper(TreeNode root){
         // Base case: If the node is null, height is 0.
        if(root == null) return 0;

        // Calculate the height of the left subtree.
        int left = helper(root.left); 
        // Calculate the height of the right subtree.
        int right = helper(root.right); 
        // Update the diameter if necessary.
        diameter = Math.max(diameter, left + right); 
        
        return Math.max(left, right) + 1; // Return the height of the current node.
    }
}
