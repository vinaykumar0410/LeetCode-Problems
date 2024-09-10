
// Tag - Medium

// using dijkstra
class Pair{
    int node;
    double prob;
    public Pair(int node,double prob){
        this.node = node;
        this.prob = prob;
    }
}
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // build graph
        List<List<Pair>> graph = new ArrayList();
        for(int i=0; i<n; i++){
            graph.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            int[] edge = edges[i];
            int u = edge[0];
            int v = edge[1];
            double prob = succProb[i];
            // populate graph
            graph.get(u).add(new Pair(v,prob));
            graph.get(v).add(new Pair(u,prob));
        }

        // init dist array which holds max probs
        double[] dist = new double[n];
        Arrays.fill(dist,0.0);
        dist[start_node] = 1.0;

        Queue<Integer> q = new LinkedList<>();
        q.offer(start_node); 

        while(!q.isEmpty()){
            int currNode = q.poll();
            List<Pair> neighbors = graph.get(currNode);
            // explore neighbors
            for(Pair pair : neighbors){
                // take out adj details from pair
                int adjNode = pair.node;
                double adjProb = pair.prob;
                // take out curr details from currNode & cal prob
                double currProb = dist[currNode];
                double nextProb = currProb * adjProb;
                // if next prob turns out to be greater than curr adj prob replace it
                if(nextProb > dist[adjNode]){
                    dist[adjNode] = nextProb;
                    // don't forget to offer adjnode
                    q.offer(adjNode);
                } 
            }
        }
        return dist[end_node];
    }
}

// using bellman ford
class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        // init max probability array, set start_node probability to 1.0
        double[] maxProb = new double[n];
        maxProb[start_node] = 1.0;
        
        // Relax edges up to n-1 times
        for(int i = 0; i < n - 1; i++) {
            boolean updated = false;
            for(int j = 0; j < edges.length; j++) {
                int u = edges[j][0];
                int v = edges[j][1];
                double currProb = succProb[j];
                
                // Update the probability if a higher one is found
                if(currProb * maxProb[u] > maxProb[v]) {
                    maxProb[v] = currProb * maxProb[u];
                    updated = true;
                }
                if(currProb * maxProb[v] > maxProb[u]) {
                    maxProb[u] = currProb * maxProb[v];
                    updated = true;
                }
            }
            // Stop early if no updates were made
            if(!updated) break;
        }
        
        // Return the maximum probability to reach end_node
        return maxProb[end_node];
    }
}