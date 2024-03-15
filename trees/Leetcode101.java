
// Tag - Easy
class Solution {
    public boolean isSymmetric(TreeNode root) {
        // Call helper function with root's left and right subtrees
        return helper(root, root);
    }
    
    // Helper function to recursively check if two subtrees are symmetric
    private boolean helper(TreeNode t1, TreeNode t2) {
        // Base case: both nodes are null, indicating symmetry
        if (t1 == null && t2 == null) 
            return true;
        
        // Base case: one node is null and the other is not, indicating asymmetry
        if (t1 == null || t2 == null) 
            return false;
        
        // Check if the values of the current nodes are equal
        // and if their subtrees are symmetric
        return t1.val == t2.val && helper(t1.left, t2.right) && helper(t1.right, t2.left);
    }
}
