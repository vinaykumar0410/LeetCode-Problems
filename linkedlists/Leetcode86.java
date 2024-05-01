
// Tag - Medium
class Solution {
    public ListNode partition(ListNode head, int x) {
        // beforeHead holds first half of LL
        ListNode beforeHead = new ListNode(0);
        // before is used to connect input nodes to beforeHead
        ListNode before = beforeHead;
        // beforeHead holds second half of LL
        ListNode afterHead = new ListNode(0);
        // after is used to connect input nodes to afterHead
        ListNode after = afterHead;
        // loop until head node becomes null
        while(head != null){
            // less than x add to first half
            if(head.val < x){
                before.next = head;
                before = before.next;
            }else{ // greater than x add to second half
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }
        // handle LL connections 
        after.next = null;
        before.next = afterHead.next;
        return beforeHead.next;
    }
}