
// Tag - Medium

class Solution {
    public String getDirections(TreeNode root, int startValue, int destValue) {
        // Find the lowest common ancestor (LCA) of the start and destination nodes
        TreeNode lca = getLca(root, startValue, destValue);

        // StringBuilders to store the paths from LCA to startValue and destValue
        StringBuilder lcaToSource = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();

        // Get the path from LCA to the start node
        getPath(lca, startValue, lcaToSource);
        // Get the path from LCA to the destination node
        getPath(lca, destValue, lcaToDest);

        // Create the final answer by adding "U" for each step up to the LCA
        // and then adding the path to the destination node
        StringBuilder ans = new StringBuilder();
        for (int i = 0; i < lcaToSource.length(); i++) {
            ans.append("U");
        }
        for (int j = lcaToDest.length() - 1; j >= 0; j--) {
            ans.append(lcaToDest.charAt(j));
        }

        // Return the final direction string
        return ans.toString();
    }

    // Helper method to find the path from a node to the target value
    boolean getPath(TreeNode root, int target, StringBuilder path) {
        if (root == null) return false; // Base case: reached end of path
        if (root.val == target) return true; // Target found

        // Recursively search in the left subtree
        if (getPath(root.left, target, path)) {
            path.append("L"); // If found, add 'L' to path
            return true;
        }

        // Recursively search in the right subtree
        if (getPath(root.right, target, path)) {
            path.append("R"); // If found, add 'R' to path
            return true;
        }

        // Target not found in either subtree
        return false;
    }

    // Helper method to find the lowest common ancestor (LCA) of two nodes
    TreeNode getLca(TreeNode root, int p, int q) {
        if (root == null || root.val == p || root.val == q) {
            return root; // Found one of the nodes or reached the end
        }

        // Recur for left and right subtrees
        TreeNode left = getLca(root.left, p, q);
        TreeNode right = getLca(root.right, p, q);

        // If both sides return non-null, current root is the LCA
        if (left != null && right != null) return root;

        // Otherwise, return the non-null side (either left or right)
        return left != null ? left : right;
    }
}