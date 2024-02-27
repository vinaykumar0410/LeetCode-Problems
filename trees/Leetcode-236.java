
// Tag - Medium
 class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // If the root is null, return null
        if(root == null) return root;
        
        // If the root is one of the nodes, it is the lowest common ancestor
        if(root == p || root == q) return root;

        // Recursively find the lowest common ancestor in the left and right subtrees
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // If one subtree returns null, the other subtree contains the ancestor
        if(left == null) return right;
        if(right == null) return left;

        // If both subtrees return non-null values, the root is the lowest common ancestor
        return root;
    }
}
