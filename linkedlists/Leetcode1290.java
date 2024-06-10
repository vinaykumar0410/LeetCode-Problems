
// Tag - Easy

class Solution {
    public int getDecimalValue(ListNode head) {
        StringBuilder sb = new StringBuilder();
        ListNode curr = head;
        while(curr != null){
            sb.append(curr.val);
            curr = curr.next;
        }
        return Integer.parseInt(sb.toString(),2);
    }
}