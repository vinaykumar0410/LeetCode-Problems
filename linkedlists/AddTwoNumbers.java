package linkedlists;

// Tag - Medium

/* 
// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
*/

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Create a dummy node to hold the result
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy; // Pointer to traverse the result list

        int sum = 0; // Variable to hold the sum of two digits
        int carry = 0; // Variable to hold the carry

        // Traverse both lists until both are null
        while (l1 != null || l2 != null) {
            // Get the value of the current nodes (or 0 if null)
            int first = l1 != null ? l1.val : 0;
            int second = l2 != null ? l2.val : 0;

            // Calculate sum and carry
            sum = first + second + carry;
            carry = sum / 10;

            // Add new node with the sum to the result list
            curr.next = new ListNode(sum % 10);
            curr = curr.next; // Move to the next node in the result list

            // Move to the next nodes in the input lists if not null
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }

        // If there is a remaining carry, add it as a new node
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        
        // Return the next node of dummy, which is the head of the result list
        return dummy.next; 
    }
}
