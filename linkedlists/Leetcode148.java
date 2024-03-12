
// Tag - Medium
class Solution {
    public ListNode sortList(ListNode head) {
        // If list is empty or contains only one node, return it.
        if (head == null || head.next == null) return head;

        ListNode prev = null; // Pointer to the node before the midpoint.
        ListNode slow = head; // Pointer moving one step at a time.
        ListNode fast = head; // Pointer moving two steps at a time.

        // Find the midpoint of the list using slow and fast pointers.
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next; // Move slow pointer by one step.
            fast = fast.next.next; // Move fast pointer by two steps.
        }

        prev.next = null; // Break the list into two parts.

        // Recursively sort the first and second halves of the list.
        ListNode first = sortList(head);
        ListNode second = sortList(slow);

        // Merge the sorted halves and return the merged list.
        return merge(first, second);
    }

    // Merges two sorted linked lists.
    private ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode(0); // Dummy node to ease merging.
        ListNode tail = dummy; // Pointer to track the tail of the merged list.

        // Traverse both lists until one of them becomes null.
        while (first != null && second != null) {
            // Compare values and link nodes accordingly.
            if (first.val < second.val) {
                tail.next = first;
                first = first.next;
            } else {
                tail.next = second;
                second = second.next;
            }
            tail = tail.next; // Move tail pointer to the last node.
        }

        // Link the remaining nodes of the non-empty list.
        if (first != null) {
            tail.next = first;
        }
        if (second != null) {
            tail.next = second;
        }

        return dummy.next; // Return the merged list.
    }
}
