
// Tag - Medium
class Solution {
    public ListNode swapPairs(ListNode head) {
        // edge case
        if(head == null || head.next == null) return head;
        List<ListNode> list = new ArrayList();
        // traverse LinkedList and add nodes to list
        ListNode curr = head;
        while(curr != null){
            list.add(curr);
            curr = curr.next;
        }
        // ans ListNode holds the output list node
        ListNode ans = new ListNode(0);
        // dummy pointer for assinging next nodes
        ListNode dummy = ans;
        // traverse listNode
        for(int i=1; i<list.size(); i+=2){
            // assign second node
            dummy.next = list.get(i);
            dummy = dummy.next;
            // assign first node
            dummy.next = list.get(i-1);
            dummy = dummy.next;
        }
        // edge case for list node even or odd
        dummy.next = list.size()%2==0 ? null : list.get(list.size()-1);
        return ans.next;
    }
}