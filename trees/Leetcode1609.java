
// Tag - Medium
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        // Queue for level-order traversal.
        Queue<TreeNode> q = new LinkedList(); 
        // Add the root to the queue.
        q.offer(root); 
        // Initialize the level indicator.
        int level = 0; 
        
        while(!q.isEmpty()){

            int size = q.size(); // Get the current level size.
            TreeNode prev = null; // Initialize the previous node.

            for(int i=0; i<size; i++){
                // Pop the node from the queue.
                TreeNode curr = q.poll(); 

                if(level % 2 == 0){ // For even levels.

                    if(curr.val % 2 == 0) return false; // If a node's value is even, return false.
                    if(prev != null && prev.val >= curr.val){ // If previous value is greater than or equal to current value, return false.
                        return false;
                    } 

                } else { // For odd levels.

                    if(curr.val % 2 != 0) return false; // If a node's value is odd, return false.
                    if(prev != null && prev.val <= curr.val){ // If previous value is less than or equal to current value, return false.
                        return false;
                    }

                }
                
                prev = curr; // Update previous node.
                if(curr.left != null) q.offer(curr.left); // Add left child to the queue if it exists.
                if(curr.right != null) q.offer(curr.right); // Add right child to the queue if it exists.
            }
            level++; // Move to the next level.
        }
        return true; // If the tree satisfies all conditions, return true.
    }
}
