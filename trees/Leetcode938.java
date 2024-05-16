// Tag - Easy
class Solution {
    // initialize sum as global variable as we use recursion
    int sum = 0;
    public int rangeSumBST(TreeNode root, int low, int high) {
        // traverse tree until root becomes null
        if(root != null){
            // call left subtree
            rangeSumBST(root.left,low,high);
            // check for base condition for adding val to sum
            if(root.val >= low && root.val <= high) sum += root.val;
            // call right subtree
            rangeSumBST(root.right,low,high);
        }
        // return the sum which holds all the tree vals that meets condition
        return sum;
    }
}
