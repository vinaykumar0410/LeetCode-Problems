
// Tag - Medium

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // [1,1,1,2,2,3] k=2 -> most freq top k elements [1,2] 1-3times 2-2times
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // {1-3,2-2,3-1}
        // sort based on values
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->b.getValue()-a.getValue()
        );
        // add all entries to pq
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            pq.offer(entry);
        }
        int[] ans = new int[k];
        for(int i=0; i<k; i++){
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}