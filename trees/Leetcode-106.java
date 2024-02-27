
// Tag - Medium
class Solution {
    int posIndex; // Index for the current position in the postorder traversal

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        posIndex = postorder.length - 1; // Start from the last index of postorder array

        // Map to store indices of values in inorder traversal
        Map<Integer, Integer> map = new HashMap(); 
        
        // Populate map with values and their indices from inorder traversal
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i); 
        }

        // Construct the tree recursively
        TreeNode root = constructTree(inorder, 0, inorder.length - 1, postorder, map);

        return root; // Return the root of the constructed tree
    }

    private TreeNode constructTree(int[] inorder, int inStart, int inEnd, int[] postorder, Map<Integer, Integer> map) {
        // Base case: if start index is greater than end index or posIndex goes out of bounds, return null
        if (inStart > inEnd || posIndex < 0)
            return null;

        // Get the value of the current root node from postorder traversal
        int val = postorder[posIndex--];
        // Create the current root node
        TreeNode root = new TreeNode(val); 

        // Find the index of the current root node's value in the inorder traversal
        int index = map.get(val);

        // Construct right subtree recursively
        root.right = constructTree(inorder, index + 1, inEnd, postorder, map);
        // Construct left subtree recursively
        root.left = constructTree(inorder, inStart, index - 1, postorder, map);

        return root; // Return the current root node
    }
}
