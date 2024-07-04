
// Tag - Medium

// dfs
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        // build graph using input edges
        List<List<Integer>> graph = new ArrayList();
        // init lists
        for(int i=0; i<n; i++){
            ans.add(new ArrayList());
            graph.add(new ArrayList());
        }
        for(int[] edge : edges){
            // [0,3] -> 3 is pointed by 0 so 0 is ancestor of 3
            graph.get(edge[1]).add(edge[0]);
        }
        // find out ancessors for every node
        for(int i=0; i<n; i++){
            int currNode = i;
            boolean[] vis = new boolean[n]; 
            List<Integer> ancessors = new ArrayList();
            dfs(graph,currNode,vis,ancessors);
            Collections.sort(ancessors);
            ans.get(currNode).addAll(ancessors);
        }
        return ans;
    }
    private void dfs(List<List<Integer>> graph, int currNode, boolean[] vis, List<Integer> ancessors){
        vis[currNode] = true;
        // go through curr node neighbors
        for(int neighbor : graph.get(currNode)){
            if(!vis[neighbor]){
                ancessors.add(neighbor);
                dfs(graph,neighbor,vis,ancessors);
            }
        }
    }
}

// bfs
class Solution {
    public List<List<Integer>> getAncestors(int n, int[][] edges) {
        List<List<Integer>> ans = new ArrayList();
        // build graph using input edges
        List<List<Integer>> graph = new ArrayList();
        // init lists
        for(int i=0; i<n; i++){
            ans.add(new ArrayList());
            graph.add(new ArrayList());
        }
        for(int[] edge : edges){
            // [0,3] -> 3 is pointed by 0 so 0 is ancestor of 3
            graph.get(edge[1]).add(edge[0]);
        }
        // find out ancessors for every node
        for(int i=0; i<n; i++){
            int currNode = i;
            boolean[] vis = new boolean[n]; 
            List<Integer> ancessors = new ArrayList();
            Queue<Integer> q = new LinkedList();
            q.offer(currNode);
            while(!q.isEmpty()){
                int curr = q.poll();
                for(int neighbor : graph.get(curr)){
                    if(!vis[neighbor]){
                        vis[neighbor] = true;
                        ancessors.add(neighbor);
                        q.offer(neighbor);
                    }
                }
            }
            Collections.sort(ancessors);
            ans.get(currNode).addAll(ancessors);
        }
        return ans;
    }
}