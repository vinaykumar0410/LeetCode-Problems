
// Tag - Medium
class Solution {
    // shortest path (graph-> dijkstra'a algorithm)
    // single datatype matters
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        // build graph
        Map<Character,List<int[]>> graph = new HashMap<>();
        for(int i=0; i<cost.length; i++){
            graph.putIfAbsent(original[i],new ArrayList<>());
            graph.get(original[i]).add(new int[]{changed[i]-'a', cost[i]});
        }
        // get shortest costToChange from source character to target character
        Map<Character,int[]> shortestPaths = new HashMap<>();
        for(char ch='a'; ch<='z'; ch++){
            shortestPaths.put(ch,dijkstra(ch-'a',graph));
        }
        long ans = 0;
        // traverse input string take out source char & target index
        for(int i=0; i<source.length(); i++){
            char sourceChar = source.charAt(i);
            int targetIndex = target.charAt(i)-'a';
            int costToChange = shortestPaths.get(sourceChar)[targetIndex];
            // if there is no path from source to target return -1
            if(costToChange == Integer.MAX_VALUE){
                return -1;
            }
            // shortest path exists add cost to ans
            ans += costToChange;
        }
        return ans;
    }
    private int[] dijkstra(int src,Map<Character,List<int[]>> graph){
        // PriorityQueue holds {cost,node}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        pq.offer(new int[]{0,src}); 
        // minCosts holds min costs to change char
        int[] minCosts = new int[26];
        Arrays.fill(minCosts,Integer.MAX_VALUE);
        minCosts[src] = 0;
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int prevCost = pair[0];
            int prevNode = pair[1];
            // if greater cost found than before do ntg
            if(prevCost > minCosts[prevNode]){
                continue;
            }
            // else take out char and explore it's neighbors
            char ch = (char)(prevNode +'a');
            for(int[] neighbor : graph.getOrDefault(ch,new ArrayList<>())){
                int currNode = neighbor[0];
                int currCost = neighbor[1];
                // calculate total cost from prev node to curr node
                int totalCost = prevCost + currCost;
                // if total cost less than before cost update it & add it to pq
                if(totalCost < minCosts[currNode]){
                    minCosts[currNode] = totalCost;
                    pq.offer(new int[]{totalCost,currNode});
                }
            }
        }
        return minCosts;
    }
}