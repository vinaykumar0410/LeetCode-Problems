
// Tag - Easy

class Solution {
    public int lastStoneWeight(int[] stones) {
        // reverse sort 
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        for(int stone : stones){
            pq.offer(stone);
        }
        // loop until pq size greater than equals 2
        while(pq.size()>=2){
            int first = pq.poll(); // 8
            int second = pq.poll(); // 7
            if(first != second){
                pq.offer(first-second);
            }
        }
        return pq.size()==1 ? pq.poll() : 0;
    }
}