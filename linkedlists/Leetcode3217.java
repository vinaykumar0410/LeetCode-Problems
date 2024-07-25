
// Tag - Medium

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        // HashSet keeps track of duplicates
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num); // add all nodes
        List<Integer> list = new ArrayList();
        for(ListNode curr=head; curr != null; curr = curr.next){
            // one valid node found since curr node not present in set 
            if(!set.contains(curr.val)){
                list.add(curr.val);
            }
        }
        // form listnode with list values
        ListNode ans = new ListNode(0);
        ListNode tail = ans;
        for(int i=0; i<list.size(); i++){
            tail.next = new ListNode(list.get(i));
            tail = tail.next;
        }
        return ans.next;
    }
}