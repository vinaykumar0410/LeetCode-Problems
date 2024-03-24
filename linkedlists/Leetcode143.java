
// Tag - Medium
class Solution {
    public void reorderList(ListNode head) {
        // Stack to store elements in reverse order.
        Stack<Integer> stack = new Stack<>();
        // Queue to store elements in original order.
        Queue<Integer> queue = new LinkedList<>();
        // Traverse the linked list to populate the stack and the queue.
        ListNode curr = head;
        while (curr != null) {
            // Push current element to the stack.
            stack.push(curr.val); 
            // Enqueue current element to the queue.
            queue.offer(curr.val); 
            // Move to the next node.
            curr = curr.next; 
        }
        
        // Reorder the linked list using elements from the stack and the queue.
        curr = head;
        int cnt = 0;
        while (curr != null) {
            cnt++;
            // If the count is even, pop an element from the stack and assign it to the current node's value.
            if (cnt % 2 == 0 && !stack.isEmpty()) {
                curr.val = stack.pop();
            } else { // Otherwise, poll an element from the queue and assign it to the current node's value.
                curr.val = queue.poll(); 
            }
            curr = curr.next; // Move to the next node.
        }
    }
}
