
// Tag - Medium
class Solution {
    public ListNode deleteMiddle(ListNode head) {
        // Base Condition
        if(head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        // why prev we need the node that is before middle node
        ListNode prev = slow;
        // slow fast pointer algo to find middle node
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        // here slow is discarded (which is middle node)
        prev.next = slow.next;
        return head;
    }
}