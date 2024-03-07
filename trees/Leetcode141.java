
// Tag - Easy
public class Solution {
    public boolean hasCycle(ListNode head) {
        // Initialize a slow pointer.
        ListNode slow = head; 
        // Initialize a fast pointer.
        ListNode fast = head; 
        
        // Traverse the linked list with two pointers, slow and fast.
        while (fast != null && fast.next != null) {
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
            // If they meet, there's a cycle.
            if (slow == fast) return true;
        }
        return false; // Return false if fast reaches the end of the list.
    }
}
