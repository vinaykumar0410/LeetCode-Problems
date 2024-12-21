
// Tag - Easy

class Solution {
    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        helper(pq, root);
        pq.poll();
        return pq.isEmpty() ? -1 : pq.poll();
    }
    private void helper(PriorityQueue<Integer> pq, TreeNode root){
        if(root != null){
            helper(pq, root.left);
            if(!pq.contains(root.val)){
                pq.offer(root.val);
            }
            helper(pq, root.right);
        }
    }
}