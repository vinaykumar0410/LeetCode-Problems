
// Tag - Medium

class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] ans = new ListNode[k];
        // calculate the total number of nodes in the linked list
        int nodes = 0;
        ListNode curr = head;
        while(curr != null){
            nodes++;
            curr = curr.next;
        }
        // calculate equal & extra nodes
        int equalNodes = nodes / k; 
        int extraNodes = nodes % k;   
        // reset the curr pointer to the head of the list
        curr = head;
        // split the list into k parts
        for(int i=0; i<k; i++){
            if(curr == null) break;  
            // store the start node of the current part
            ans[i] = curr;
            // traverse through the part to set its size
            ListNode prev = null;
            for(int j=0; j<equalNodes; j++){
                prev = curr;
                curr = curr.next;
            }
            // if there are extra nodes left to distribute, add one more node to the current part
            if(extraNodes > 0){
                prev = curr;
                curr = curr.next;
                extraNodes--;
            }
            // disconnect the current part from the next part
            prev.next = null;
        }
        return ans;
    }
}