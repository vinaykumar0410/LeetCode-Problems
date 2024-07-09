
// Tag - Medium

 // TC - O(n)
 // SC - O(n) can do it in O(1) 
 class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> list = new ArrayList();
        ListNode temp = head;
        // iterate through the input list node add all nodes to list
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        // filter critical points
        List<Integer> filter = new ArrayList();
        for(int i=1; i<list.size()-1; i++){
            int prev = list.get(i-1);
            int curr = list.get(i);
            int next = list.get(i+1);
            if(curr > prev && curr > next || curr < prev && curr < next){
                filter.add(i);
            }
        }
        // find out min and max 
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=1; i<filter.size(); i++){
            // hint-1
            min = Math.min(min,filter.get(i)-filter.get(i-1));
        }
        if(min == Integer.MAX_VALUE) min = -1;
        if(filter.size() >= 2){
            // hint-2
            max = filter.get(filter.size()-1)-filter.get(0);
        }else{
            max = -1;
        }
        return new int[]{min,max};
    }
}