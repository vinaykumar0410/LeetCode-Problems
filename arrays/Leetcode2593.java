
// Tag - Medium

class Solution {
    public long findScore(int[] nums) {
        // pq holds element,index
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a,b)->{
                // If there is a tie, choose the one with the smallest index.
                if(Integer.compare(a[0],b[0]) == 0){
                    return Integer.compare(a[1],b[1]);
                }else{
                    // Choose the smallest integer of the array that is not marked
                    return Integer.compare(a[0],b[0]);
                }
            }
        );

        // populate priority queue
        for(int i=0; i<nums.length; i++){
            pq.offer(new int[]{nums[i],i});
        }

        long score = 0;
        // 1-1, 2-0, 2-5, 3-2, 4-3, 5-4
        boolean[] vis = new boolean[nums.length];
        while(!pq.isEmpty()){
            int[] pair = pq.poll(); // 1
            // not visited?
            if(!vis[pair[1]]){
                // add score
                score += pair[0]; 
                // mark it as visited & also their neighbors
                vis[pair[1]] = true; 
                if(pair[1]-1 >= 0){
                    vis[pair[1]-1] = true;
                } 
                if(pair[1]+1 < nums.length){
                    vis[pair[1]+1] = true;
                } 
            }
        }
        return score;
    }
}

