
// Tag - Medium

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        // forests is the output list holds all forests after deleting nodes
        List<TreeNode> forests = new ArrayList();
        // deleteNodes is a list of nodes to be deleted
        Set<Integer> deleteNodes = new HashSet();
        for(int node : to_delete){
            deleteNodes.add(node);
        }
        // helper function helps to delete nodes and fill forests list
        root = helper(root,deleteNodes,forests);
        // edge case
        if(root != null){
            forests.add(root);
        }
        return forests;
    }
    // only post order traversal works here 
    // first we need to check childrens later parent or root node
    TreeNode helper(TreeNode root, Set<Integer> deleteNodes,List<TreeNode> forests){
        // base condition
        if(root == null){
            return root;
        } 
        // call left subtree
        root.left = helper(root.left,deleteNodes,forests);
        // call right subtree
        root.right = helper(root.right,deleteNodes,forests);
        // process root node
        if(deleteNodes.contains(root.val)){
            // node to be deleted found (child nodes are valid forests)
            if(root.left != null){
                forests.add(root.left);
            }
            if(root.right != null){
                forests.add(root.right);
            }
            // return null it indicates deleting current node
            return null;
        }
        // no need to delete current node return same node
        return root;
    }
}