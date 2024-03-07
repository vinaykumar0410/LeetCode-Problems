
// Tag - Medium
class Solution {

    public int sumNumbers(TreeNode root) {
        return helper(root, 0);
    }
    
    // Helper method to recursively traverse the tree and calculate the sum.
    private int helper(TreeNode root, int ans) {
        // If the current node is null, return 0.
        if (root == null) return 0; 
        // If the current node is a leaf node, return the sum.
        if (root.left == null && root.right == null) 
            return ans * 10 + root.val;
        // Recursively calculate the sum by traversing left and right subtrees.
        return helper(root.left, ans * 10 + root.val) + helper(root.right, ans * 10 + root.val);
    }
}
