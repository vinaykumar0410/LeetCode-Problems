
// Tag - Medium
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Map to store the indices of inorder traversal values for quick access
        Map<Integer,Integer> map = new HashMap();
        
        // Populate the map with inorder traversal indices
        for(int i=0; i<inorder.length; i++){
            map.put(inorder[i], i);
        }
        
        // Call the helper function to recursively build the tree
        return build(preorder, 0, inorder, 0, inorder.length-1, map);
    }

    private TreeNode build(int[] preorder, int preStart, int[] inorder, int inStart, int inEnd, Map<Integer,Integer> map){
        // Base case: if the indices are invalid, return null
        if(preStart > preorder.length-1 || inStart > inEnd) return null;

        // Value of the current root node
        int val = preorder[preStart];
        TreeNode root = new TreeNode(val);
        
        // Find the index of the root value in the inorder traversal
        int index = map.get(val);

        // Recursively build left and right subtrees
        root.left = build(preorder, preStart+1, inorder, inStart, index-1, map);
        root.right = build(preorder, preStart+index-inStart+1, inorder, index+1, inEnd, map);

        // Return the constructed root
        return root;
    }
}
