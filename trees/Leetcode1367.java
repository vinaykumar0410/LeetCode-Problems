
// Tag - Medium

class Solution {
    public boolean isSubPath(ListNode head, TreeNode root) {
        // base cases
        if(head == null) return true;
        if(root == null) return false;

        // one of the case 
        if(head.val == root.val){
            if(helper(head,root)) return true;
        }

        // check left & right subtrees
        return isSubPath(head,root.left) || isSubPath(head,root.right);
    }
    private boolean helper(ListNode head, TreeNode root){
        // base cases
        if(head == null) return true;
        if(root == null) return false;

        // invalid case
        if(head.val != root.val) return false;

        // above case valid so it reached here call next one
        return helper(head.next,root.left) || helper(head.next,root.right);
    }
}