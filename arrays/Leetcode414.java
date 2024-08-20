
// Tag - Easy

class Solution {
    public int thirdMax(int[] nums) {
        // to filter duplicates
        Set<Integer> set = new HashSet();
        for(int num : nums) set.add(num); // 1 2 
        PriorityQueue<Integer> pq = new PriorityQueue<>(set);
        while(pq.size() > 3){
            pq.poll();
        }
        // edge case
        if(pq.size() == 2){
            pq.poll();
        }
        return pq.poll();
    }
}