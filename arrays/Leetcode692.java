
// Tag - Medium

class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> list = new ArrayList();
        Map<String,Integer> map = new HashMap();
        for(String word : words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        // i-2 love-2 leetcode-1 coding-1
        // sort based on values
        PriorityQueue<Map.Entry<String,Integer>> pq = new PriorityQueue<>(
            (a,b)->{
                // if values equals compare strings
                if(b.getValue() == a.getValue()){
                    return a.getKey().compareTo(b.getKey());
                }else{
                    return b.getValue()-a.getValue();
                }
            }
        );
        // add all hashmap entries to pq
        pq.addAll(map.entrySet());
        while(!pq.isEmpty() && k-->0){
            Map.Entry<String,Integer> entry = pq.poll();
            list.add(entry.getKey());
        }
        return list;
    }
}