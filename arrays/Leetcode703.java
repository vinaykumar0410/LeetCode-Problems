
// Tag - Easy

class KthLargest {

    PriorityQueue<Integer> pq;
    int temp = 0;
    public KthLargest(int k, int[] nums) {
        temp = k;
        pq = new PriorityQueue<>(k);
        // pq size should limit to size k
        for(int num : nums){
            pq.offer(num);
            // if pq size exceeds k poll element
            if(pq.size() > k){
                pq.poll();
            }
        }
    }
    
    public int add(int val) {
        pq.offer(val);
        // if pq size exceeds k poll element
        if(pq.size() > temp){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */