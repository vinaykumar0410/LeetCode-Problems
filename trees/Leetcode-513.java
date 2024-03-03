
// Tag - Medium
class Solution {
    public int findBottomLeftValue(TreeNode root) {
        // Initialize the value of the bottom left node.
        int bottomLeftOne = 0; 
        // Edge case
        if(root == null) return bottomLeftOne; 
        // Queue for level-order traversal.
        Queue<TreeNode> q = new LinkedList(); 
        // Add the root to the queue.
        q.offer(root); 
        // Continue until all nodes are processed.
        while(!q.isEmpty()){ 
            int size = q.size(); // Get the current level size.

            // Traverse each node at the current level.
            for(int i=0; i<size; i++){ 
                TreeNode curr = q.poll(); // Pop the node from the queue.
                // Update bottomLeftOne if it's the first node at this level.
                if(i==0) bottomLeftOne = curr.val; 
                if(curr.left != null) q.offer(curr.left); // Add the left child to the queue if it exists.
                if(curr.right != null) q.offer(curr.right); // Add the right child to the queue if it exists.
            }
        }
        // Return the value of the bottom left node.
        return bottomLeftOne; 
    }
}
