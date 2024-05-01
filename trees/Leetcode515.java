
// Tag - Medium
class Solution {
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> list = new ArrayList();
        // Base Case
        if(root == null) return list;
        // init Queue and add root
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        // loop until queue is not empty
        while(!q.isEmpty()){
            int size = q.size();
            int max = Integer.MIN_VALUE;
            // loop through each level
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                // cal max val for each level
                if(curr.val > max) max = curr.val;
                if(curr.left != null) q.offer(curr.left); 
                if(curr.right != null) q.offer(curr.right);  
            }
            // add max val to list
            list.add(max);
        }
        return list;
    }
}