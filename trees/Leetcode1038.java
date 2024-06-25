
// Tag - Medium
class Solution {
    int sum = 0;
    public TreeNode bstToGst(TreeNode root) {
        // reverse inorder
        if(root != null){
            bstToGst(root.right);
            sum += root.val;
            root.val = sum;
            bstToGst(root.left);
        }
        return root;
    }
}