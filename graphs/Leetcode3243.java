
// Tag - Medium

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // Build graph 
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for(int i = 0; i < n; i++){
            graph.putIfAbsent(i, new ArrayList<>());
             // Each node i points to i+1
            graph.get(i).add(i + 1);
        }
        // Example: graph = {{0->1}, {1->2}, {2->3}, {3->4}}
        
        // Array to store results after each query
        int[] ans = new int[queries.length]; 
        
        // Process each query
        for(int i = 0; i < queries.length; i++){
            int u = queries[i][0]; // Starting node of the edge
            int v = queries[i][1]; // Ending node of the edge
            graph.putIfAbsent(u, new ArrayList<>());
            // Add the new edge to the graph
            graph.get(u).add(v); 
            
            // Find the shortest distance from node 0 to node n-1 after the query
            ans[i] = bfs(graph, n);
        }
        
        return ans;
    }
    
    // BFS to find the shortest distance from node 0 to node n-1
    private int bfs(Map<Integer, List<Integer>> graph, int n){
        // Distance array to store shortest distances
        int[] dist = new int[n + 1]; 
        // Initialize distances with -1 (unvisited)
        Arrays.fill(dist, -1); 
        // Starting node (node 0) has distance 0
        dist[0] = 0; 
        
        Queue<Integer> q = new LinkedList<>();
        // Start BFS from node 0
        q.offer(0); 
        
        while(!q.isEmpty()){
            int curr = q.poll();
            if(graph.containsKey(curr)){
                for(int neighbor : graph.get(curr)){
                    // If neighbor hasn't been visited
                    if(dist[neighbor] == -1){ 
                        // Update distance
                        dist[neighbor] = dist[curr] + 1; 
                        // Add neighbor to the queue
                        q.offer(neighbor); 
                    }
                }
            }
        }
        // Return the shortest distance to node n-1
        return dist[n - 1]; 
    }
}
