
// Tag - Medium

class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        // build graph (currNode,[[neighbor,dist],[neighbor,dist],...])
        Map<Integer,List<int[]>> graph = new HashMap();
        buildGraph(graph,edges,n);
        // traverse each node and apply bfs(dijkstra's algo) on each node 
        int resSoFar = -1; 
        int minSoFar = n; 
        for(int node=0; node<n; node++){
            // bfs gives no of cities connected at threshold distance
            int currentCount = bfs(node,graph,distanceThreshold);
            if(currentCount <= minSoFar){
                minSoFar = currentCount;
                resSoFar = node;
            }
        }
        return resSoFar;
    }
    private void buildGraph(Map<Integer,List<int[]>> graph,int[][] edges,int n){
        // init graph
        for(int i=0; i<n; i++){
            graph.put(i,new ArrayList<>());
        }
        // construct graph with edges
        for(int[] edge : edges){
            // each edge contains src dest dist
            int src = edge[0];
            int dest = edge[1];
            int dist = edge[2];
            // populate graph with values
            graph.get(src).add(new int[]{dest,dist});
            graph.get(dest).add(new int[]{src,dist});
        }
    }
    private int bfs(int src, Map<Integer,List<int[]>> graph, int threshold){
        // PriorityQueue (min heap with {distance,node})
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[0]-b[0]);
        // actual distance btn src to src is 0
        pq.offer(new int[]{0,src}); 
        // Visited set keeps track of count of nodes up to threshold
        Set<Integer> visited = new HashSet(); 
        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int prevDist = pair[0];
            int prevNode = pair[1];
            // visited means processed
            if(visited.contains(prevNode)){
                continue;
            }
            visited.add(prevNode);
            // explore neighbors
            for(int[] neighbor : graph.get(prevNode)){
                int currNode = neighbor[0];
                int currDist = neighbor[1];
                int totalDist = prevDist + currDist;
                // base condition
                if(totalDist <= threshold && !visited.contains(currNode)){
                    pq.offer(new int[]{totalDist,currNode});
                }
            }
        }
        return visited.size()-1; // should not include src
    }
}
