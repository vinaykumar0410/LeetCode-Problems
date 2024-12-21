
// Tag - Hard

class Solution {
    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        // build adjList (undirected)
        List<List<Integer>> adjList = new ArrayList();
        for(int i=0; i<n; i++){
            adjList.add(new ArrayList());
        }
        for(int[] edge : edges){
            int src = edge[0];
            int dest = edge[1];
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }
        int[] ans = new int[1];
        // call dfs with node, parent, ..
        dfs(0, -1, adjList, values, k, ans);
        return ans[0];
    }
    private long dfs(int node, int parent,List<List<Integer>> adjList,int[] values, int k, int[] ans){
        // calculate sum of all neighbors
        long sum = values[node];
        for(int neighbor : adjList.get(node)){
            if(neighbor != parent){
                sum += dfs(neighbor, node, adjList, values, k, ans);
            }
        }
        // count if sum is divisible by k
        if(sum%k == 0){
            ans[0]++;
            return 0;
        }
        return sum;
    }
}