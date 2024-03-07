
// Tag - Easy
class Solution {
    public ListNode middleNode(ListNode head) {
         // Initialize a slow pointer.
        ListNode slow = head;
        // Initialize a fast pointer.
        ListNode fast = head; 
        
        // Move slow pointer by one step and fast pointer by two steps until fast reaches the end.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
        }
        
        return slow; // Return the middle node.
    }
}
