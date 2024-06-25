
// Tag - Hard
class Solution {
    public int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        List<int[]> projects = new ArrayList();
        for(int i=0; i<profits.length; i++){
            projects.add(new int[]{capital[i],profits[i]});
        } 
        // [[0,1],[1,2],[1,3]]
        Collections.sort(projects,(a,b)->a[0]-b[0]);
        PriorityQueue<Integer> profitsMaxHeap = new PriorityQueue<>(
            (a,b)->b-a 
            // can use Collection.reverseOrder() instead
        );
        // can do k projects
        int j = 0;
        while(k-->0){
            // if our current capital w less than or equals 
            while(j < projects.size() && projects.get(j)[0] <= w){
                // move profit of that capital to pq
                profitsMaxHeap.offer(projects.get(j)[1]);
                j++;
            }
            // check if pq is empty we cant do any projects
            if(profitsMaxHeap.isEmpty()){
                break;
            }
            w += profitsMaxHeap.poll();
        }
        return w;
    }
}