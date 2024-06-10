
// Tag - Medium

class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode ans = new ListNode(0);
        ListNode dummy = ans;
        ListNode curr = head;
        boolean start = false;
        boolean end = false;
        int sum = 0;
        while(curr != null){
            if(!start && curr.val==0){
                start = true;
            }else if(start && curr.val!=0){
                sum += curr.val;
            }else if(start && curr.val==0){
                end = true;
                dummy.next = new ListNode(sum);
                dummy = dummy.next;
                sum = 0;
            }
            curr = curr.next;
        }
        return ans.next;
    }
}