
// Tag - Medium

class Solution {
    public int halveArray(int[] nums) {
        int operations = 0;
        // PriorityQueue is used for custom sorting
        PriorityQueue<Double> pq = new PriorityQueue<>((a,b)->Double.compare(b,a));
        double totalSum = 0;
        // add all elements to PriorityQueue & calculate total sum
        for(int num : nums){
            totalSum += num;
            pq.offer((double)num);
        }
        // initialize half of total sum
        double half = totalSum/2;
        // loop until half of total sum is reached
        while(half < totalSum){
            // poll out elements and add them to half & add element half to PriorityQueue
            double num = pq.poll();
            half += num/2;
            pq.offer(num/2);
            // increment operations
            operations++;
        }
        // return operations
        return operations;
    }
}