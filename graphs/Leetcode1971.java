
// Tag - Easy

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create a graph representation using adjacency list.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            // Start vertex of the edge.
            int u = edge[0]; 
            // End vertex of the edge.
            int v = edge[1]; 
            // Add u as neighbor of v and v as neighbor of u.
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }

        // Array to mark visited vertices.
        boolean[] visited = new boolean[n];

        // Queue for BFS traversal.
        Queue<Integer> queue = new LinkedList<>();
        // Start BFS traversal from the source.
        queue.offer(source); 
        // Mark source as visited.
        visited[source] = true; 

        // Perform BFS traversal.
        while (!queue.isEmpty()) {
            // Dequeue current vertex.
            int current = queue.poll(); 
            // If current reaches destination, return true.
            if (current == destination) return true;
            // Visit all neighbors of current vertex.
            for (int neighbor : graph.get(current)) {
                // If neighbor is not visited, mark it as visited and enqueue it.
                if (!visited[neighbor]) {
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        // No valid path found from source to destination.
        return false;
    }
}

/*
class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        // Create the graph representation using adjacency lists.
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u, key -> new ArrayList<>()).add(v);
            graph.computeIfAbsent(v, key -> new ArrayList<>()).add(u);
        }
        
        // Perform DFS traversal to find a path from source to destination.
        boolean[] visited = new boolean[n];
        return dfs(graph, source, destination, visited);
    }
    
    // Depth-First Search function to find a path from source to destination.
    private boolean dfs(Map<Integer, List<Integer>> graph, int src, int dest, boolean[] visited) {
        // If we reach the destination, return true.
        if (src == dest) 
            return true;
        
        // Mark the current node as visited.
        visited[src] = true;
        
        // Explore neighbors of the current node.
        for (int neighbor : graph.getOrDefault(src, Collections.emptyList())) {
            // If the neighbor has not been visited yet, explore it.
            if (!visited[neighbor]) {
                if (dfs(graph, neighbor, dest, visited)) // If a path is found, return true.
                    return true;
            }
        }
        
        // If no path is found from this node, return false.
        return false;
    }
}

*/

