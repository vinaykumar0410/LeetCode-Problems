
// Tag - Medium

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList();
        // add 1 to n numbers
        for(int i=1; i<=n; i++) q.offer(i);
        while(q.size()!=1){
            for(int i=1; i<=k-1; i++) q.offer(q.poll());
            // pull out every kth number
            q.poll();
        }
        return q.poll();
    }
}