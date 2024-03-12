
// Tag - Easy
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Check for empty lists.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        // Dummy node that points result list prev node.
        ListNode dummy = new ListNode(0); 
        // Pointer to track the tail of the merged list.
        ListNode tail = dummy; 

        // Traverse both lists until one of them becomes null.
        while (list1 != null && list2 != null) {
            // Compare values and link nodes accordingly.
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            // Move tail pointer to the last node.
            tail = tail.next; 
        }

        // Link the remaining nodes of the non-empty list.
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next; // Return the merged list.
    }
}
