
// Tag - Medium
class Solution {
    public int maxLevelSum(TreeNode root) {
        // init queue and add root
        Queue<TreeNode> q = new LinkedList();
        q.offer(root);
        int level = 0;
        int ans = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        // loop until queue is not empty
        while(!q.isEmpty()){
            level++;
            int size = q.size();
            int currSum = 0;
            // loop through the level
            for(int i=0; i<size; i++){
                TreeNode curr = q.poll();
                // add node val to currSum
                currSum += curr.val;
                if(curr.left != null) q.offer(curr.left);
                if(curr.right != null) q.offer(curr.right);
            }
            // find maxSum and update level
            if(currSum > maxSum){
                ans = level;
                maxSum = currSum;
            } 
        }
        return ans;
    }
}