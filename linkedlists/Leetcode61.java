
// Tag - Medium
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // Check if list is empty or rotation is unnecessary
        if(head == null || k == 0) 
            return head;
        
        ListNode curr = head;
        // Initialize length of the list
        int len = 1; 
        
        // Traverse to the end of the list and count the length
        while(curr.next != null) {
            curr = curr.next;
            len++;
        }
        
        // Make the list circular
        curr.next = head;
        
        // Calculate the effective rotation amount
        k %= len;
        
        // Traverse to the node before the new head after rotation
        for(int i = 0; i < len - k; i++) {
            curr = curr.next;
        }
        
        // Update head and break the circular list
        head = curr.next;
        curr.next = null;
        
        return head; // Return the new head after rotation
    }
}
