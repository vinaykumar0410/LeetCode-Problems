
// Tag - Easy
class Solution {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {

        // store leaf values in these lists and compare
        List<Integer> leaves1 = new ArrayList<>();
        List<Integer> leaves2 = new ArrayList<>();

        // call collectLeafValues for tree-1 
        collectLeafValues(root1,leaves1);
        // call collectLeafValues for tree-2
        collectLeafValues(root2,leaves2);
        // check both lists 
        return leaves1.equals(leaves2);
    }
    // basic tree traversal
    public void collectLeafValues(TreeNode root,List<Integer> leaves){

        if(root != null){
            // check for base condition that gives leaf values
            if(root.left == null && root.right == null){
                leaves.add(root.val);
            }
            collectLeafValues(root.left,leaves);
            collectLeafValues(root.right,leaves);
        }
    }
}