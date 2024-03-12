
// Tag - Easy
public class Solution {
    public boolean hasCycle(ListNode head) {

        // Initialize two pointers: slow and fast.
        ListNode slow = head;
        ListNode fast = head;

        // Traverse the list with two pointers.
        while(fast != null && fast.next != null){
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
            // If slow and fast meet, there's a cycle.
            if(slow == fast) return true;
        }
        
        // If fast reaches the end, no cycle detected.
        return false;
    }
}
