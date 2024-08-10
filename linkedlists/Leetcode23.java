
// Tag - Medium

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // Check if the input array is empty or null
        if (lists.length == 0 || lists == null) {
            return null;
        }

        // List to store all node values
        List<Integer> listOfVals = new ArrayList<>(); 

        // Extract all node values from each list
        for (ListNode list : lists) {
            while (list != null) {
                // Add value to the list
                listOfVals.add(list.val); 
                // Move to the next node
                list = list.next; 
            }
        }

        // Sort the collected values
        Collections.sort(listOfVals); 

        // Dummy node to start the merged list
        ListNode ans = new ListNode(0); 
        // Pointer to the last node in the merged list
        ListNode tail = ans; 

        // Create the merged list using the sorted values
        for (int i = 0; i < listOfVals.size(); i++) {
            // Add new node with the sorted value
            tail.next = new ListNode(listOfVals.get(i)); 
            // Move the tail pointer to the new last node
            tail = tail.next; 
        }

        // Ensure the last node points to null
        tail.next = null; 

        // Return the merged list, skipping the dummy node
        return ans.next; 
    }
}
