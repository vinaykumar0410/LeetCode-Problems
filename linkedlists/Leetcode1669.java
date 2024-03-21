
// Tag - Medium
class Solution {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode start = null;
        ListNode end = list1;

        // Traverse list1 to find the (a-1)-th node and the b-th node.
        for (int i = 0; i < b; i++) {
            if (i == a - 1) {
                start = end; // Save the (a-1)-th node.
            }
            end = end.next;
        }

        // Connect the (a-1)-th node to the head of list2.
        start.next = list2;

        // Traverse to the end of list2.
        while (list2.next != null) {
            list2 = list2.next;
        }

        // Connect the last node of list2 to the node after the b-th node.
        list2.next = end.next;

        return list1;
    }
}
