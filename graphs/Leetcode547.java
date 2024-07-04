
// Tag - Medium

// bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // take out input array length 
        int n = isConnected.length;
        // vis array not to struck in a cycle
        boolean[] vis = new boolean[n];
        int cnt = 0;
        // loop over all nodes of input array
        for(int i=0; i<n; i++){
            // not visited 
            if(!vis[i]){
                // count and call dfs 
                cnt++;
                dfs(isConnected,i,n,vis);
            }
        }
        return cnt;
    }
    void dfs(int[][] isConnected,int curr,int n,boolean[] vis){
        // mark curr node as visited
        vis[curr] = true;
        // go through all nodes of curr node neighbors
        for(int i=0; i<n; i++){
            // not visited and have direct connection ?
            if(!vis[i] && isConnected[curr][i] == 1){
                // call dfs again for neighbor
                dfs(isConnected,i,n,vis);
            }
        }
    }
}

// bfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        // take out input array length 
        int n = isConnected.length;
        // vis array not to struck in a cycle
        boolean[] vis = new boolean[n];
        int cnt = 0;
        // loop over all nodes of input array
        for(int i=0; i<n; i++){
            // not visited 
            if(!vis[i]){
                cnt++;
                // init queue and add curr node to queue
                Queue<Integer> q = new LinkedList();
                q.offer(i);
                // mark curr node as visited
                vis[i] = true;
                // loop until queue is no more empty
                while(!q.isEmpty()){
                    // poll out curr node
                    int curr = q.poll();
                    for(int j=0; j<n; j++){
                        // and check for not visited and direct connection btn curr node and neighbor
                        if(!vis[j] && isConnected[curr][j] == 1){
                            // mark it as visited and add neighbor to queue
                            vis[j] = true;
                            q.offer(j);
                        }
                    }
                }
            }
        }
        return cnt;
    }
}