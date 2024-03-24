
// Tag - Easy
class Solution {
    public boolean isPalindrome(ListNode head) {
        // Edge Case
        if(head == null || head.next == null) return true;

        // Step-1 Find Out Middle node of LinkedList
        ListNode middleNode = getMiddleNode(head);
        // Step-2 Reverse Second part from middle node to end
        ListNode reversedLinkedList = reverseLinkedList(middleNode);
        // Step-3 Compare like a 2 pointer approach
        while(reversedLinkedList != null){
            if(head.val != reversedLinkedList.val) return false;
            head = head.next;
            reversedLinkedList = reversedLinkedList.next;
        }
        return true;
    }
    // method to find out middle node of LinkedList
    private ListNode getMiddleNode(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    // method to reverse LinkedList
    private ListNode reverseLinkedList(ListNode head){
        ListNode prev = null;
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }        
        return prev;
    }
}