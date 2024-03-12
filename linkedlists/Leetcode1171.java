
// Tag - Medium
class Solution {
    public ListNode removeZeroSumSublists(ListNode head) {
        // Map to store cumulative sums and their corresponding nodes.
        Map<Integer, ListNode> map = new HashMap<>(); 

        ListNode dummy = new ListNode(0); // Dummy node to handle edge cases.
        dummy.next = head; // Connect dummy node to the head of the list.
        
        int sum = 0; // Cumulative sum variable.
        
        // Traverse the list to calculate cumulative sums and store them in the map.
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val; // Update cumulative sum.
            map.put(sum, curr); // Store the cumulative sum and its corresponding node.
        }
    
        sum = 0; // Reset the cumulative sum.
        
        // Traverse the list again to remove zero-sum sublists.
        for (ListNode curr = dummy; curr != null; curr = curr.next) {
            sum += curr.val; // Update cumulative sum.
            curr.next = map.get(sum).next; // Connect the current node to the next node with the same cumulative sum.
        }
        
        return dummy.next; // Return the head of the modified list.
    }
}

