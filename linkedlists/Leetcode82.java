
// Tag - Medium

// Optimal Solution
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Dummy node to handle edge cases.
        ListNode dummy = new ListNode(0, head); 
        // Pointer to track the node before the current node.
        ListNode prev = dummy; 
        
        // Traverse the list until reaching the end.
        while (head != null) {
            // If duplicate nodes are found, remove them.
            if (head.next != null && head.val == head.next.val) {
                while (head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                prev.next = head.next; // Remove the duplicate nodes.
            } else {
                prev = prev.next; // Move prev pointer forward.
            }
            head = head.next; // Move head pointer forward.
        }
        
        return dummy.next; // Return the head of the modified list.
    }
}


/*
 // Brute Force Solution
 class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        // Create a HashMap to store the frequency of each node's value.
        Map<Integer, Integer> map = new HashMap<>();
        ListNode curr = head; // Pointer to traverse the list.
        
        // Count the frequency of each node's value.
        while (curr != null) {
            map.put(curr.val, map.getOrDefault(curr.val, 0) + 1);
            curr = curr.next;
        }
        
        ListNode dummy = new ListNode(0); // Dummy node for ease of construction.
        ListNode ans = dummy; // Pointer to construct the resulting list.
        curr = head; // Reset the pointer to the head of the list.
        
        // Traverse the list again to construct the resulting list.
        while (curr != null) {
            // If the node's value appears only once, add it to the resulting list.
            if (map.get(curr.val) == 1) {
                ans.next = curr;
                ans = ans.next;
            }
            curr = curr.next;
        }
        
        // Terminate the resulting list.
        ans.next = null; 
        return dummy.next; // Return the head of the resulting list.
    }
}

 */