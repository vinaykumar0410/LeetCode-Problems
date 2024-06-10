
 /*
class Solution {
    public int pairSum(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode curr = head;
        while(curr != null){
            list.add(curr.val);
            curr = curr.next;
        }
        int i = 0;
        int j = list.size()-1;
        int ans = Integer.MIN_VALUE;
        while(i < j){
            ans = Math.max(ans,list.get(i)+list.get(j));
            i++;
            j--;
        }
        return ans;  
    }
}

*/

class Solution {
    public int pairSum(ListNode head) {
        // find middle node
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode second = slow;
        // reverse second LinkedList
        ListNode reversedSecond = rev(second);
        ListNode first = head;
        int ans = Integer.MIN_VALUE;
        while(first != null && reversedSecond != null){
            ans = Math.max(ans,first.val+reversedSecond.val);
            first = first.next;
            reversedSecond = reversedSecond.next;
        }
        return ans;    
    }
    // reverse LinkedList
    ListNode rev(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode curr = head.next;
            head.next = prev;
            prev = head;
            head = curr;
        }
        return prev;
    }
}