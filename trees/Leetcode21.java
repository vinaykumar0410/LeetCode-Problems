
// Tag - Easy
class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // If one of the lists is null, return the other list.
        if (list1 == null) return list2;
        if (list2 == null) return list1;

        ListNode dummy = new ListNode(0); // Create a dummy node to ease merging.
        ListNode tail = dummy; // Initialize a tail pointer.

        // Merge the two lists while maintaining the sorted order.
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) { // If value of list1 is smaller, attach list1 to tail.
                tail.next = list1;
                list1 = list1.next; // Move list1 pointer forward.
            } else { // If value of list2 is smaller or equal, attach list2 to tail.
                tail.next = list2;
                list2 = list2.next; // Move list2 pointer forward.
            }
            tail = tail.next; // Move tail pointer forward.
        }

        // Attach remaining nodes from list1 or list2, if any.
        if (list1 != null) {
            tail.next = list1;
        }
        if (list2 != null) {
            tail.next = list2;
        }

        return dummy.next; // Return the merged list.
    }
}
