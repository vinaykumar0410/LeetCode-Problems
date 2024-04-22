
// Tag - Easy

class Solution {
    public TreeNode searchBST(TreeNode root, int val) {
        // Check if the root is not null
        if (root != null) {
            // If the value of the root node is equal to the target value, return the root node
            if (root.val == val) return root;
            // If the value of the root node is greater than the target value, search in the left subtree
            else if (root.val > val) {
                return searchBST(root.left, val);
            } else { // If the value of the root node is less than the target value, search in the right subtree
                return searchBST(root.right, val);
            }
        }
        // If the root is null or the target value is not found, return null
        return null;
    }
}
