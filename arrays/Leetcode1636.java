
// Tag - Easy
class Solution {
    public int[] frequencySort(int[] nums) {
        int[] ans = new int[nums.length];
        // map holds freq of each num
        Map<Integer,Integer> map = new HashMap();
        for(int num : nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        // PriorityQueue is used for custom sorting
        PriorityQueue<Map.Entry<Integer,Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                // found same freq sort in descending order by keys
                if(a.getValue() == b.getValue()){
                    return b.getKey() - a.getKey();
                }else{ // found different freq sort in increasing order by values 
                    return a.getValue() - b.getValue();
                }
            }
        );
        // add all map entries to PriorityQueue
        pq.addAll(map.entrySet());
        int i = 0;
        while(!pq.isEmpty()){
            // pull out entries and add num to ans for freq times
            Map.Entry<Integer,Integer> pair = pq.poll();
            int freq = pair.getValue();
            while(freq-->0){
                ans[i++] = pair.getKey();
            }
        }
        return ans;
    }
}