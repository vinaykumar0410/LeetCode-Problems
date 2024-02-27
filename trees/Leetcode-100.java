
// Tag - Easy
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // If both trees are empty, they are the same
        if(p == null && q == null) return true;
        
        // If one tree is empty while the other is not, they are not the same
        if(p == null || q == null) return false;
        
        // Check if the current nodes' values are the same
        // and recursively check the left and right subtrees
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
