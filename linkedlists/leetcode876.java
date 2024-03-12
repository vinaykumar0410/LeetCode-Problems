
// Tag - Easy
class Solution {
    public ListNode middleNode(ListNode head) {
        // Pointer moving one step at a time.
        ListNode slow = head; 
        // Pointer moving two steps at a time.
        ListNode fast = head; 
        
        // Traverse the list until the fast pointer reaches the end.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
        }
        
        return slow; // Return the middle node.
    }
}
