
// Tag - Medium

class Solution {
    public ListNode oddEvenList(ListNode head) {
        // odds and evens are two lists for holding odd and even nodes
        ListNode odds = new ListNode(0);
        // oddsTail and evenTail are used to assign respective nodes
        ListNode oddsTail = odds;
        ListNode evens = new ListNode(0);
        ListNode evenTail = evens;
        // traverse the input list node
        ListNode curr = head;
        // ofCourse first is odd (problem description)
        boolean isOdd = true;
        while(curr != null){
            // assign respective nodes
            if(isOdd){
                oddsTail.next = curr;
                oddsTail = oddsTail.next;
            }else{
                evenTail.next = curr;
                evenTail = evenTail.next;
            }
            isOdd = !isOdd;
            curr = curr.next;
        }
        // connect odd list to even list
        oddsTail.next = evens.next;
        // make even list null and return
        evenTail.next = null;
        return odds.next;
    }
}