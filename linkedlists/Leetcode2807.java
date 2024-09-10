
// Tag - Medium

class Solution {
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        // base case
        if(head == null || head.next == null){
            return head;
        }
        // traverse the list until we have atleast two nodes to calculate gcd
        ListNode curr = head;
        while(curr.next != null){
            // create gcd node
            ListNode gcd = new ListNode(gcd(curr.val,curr.next.val));
            // both curr & gcd points curr.next (curr->curr.next<-gcd)
            gcd.next = curr.next;
            // change curr next link from curr next to gcd
            curr.next = gcd;
            // move curr 2 times
            curr = curr.next.next;
        }
        return head;
    }
    // basic gcd code
    private int gcd(int a,int b){
        if(a == b){
            return a;
        }
        if(a > b){
            return gcd(a-b,b);
        }
        return gcd(a,b-a);
    }
}