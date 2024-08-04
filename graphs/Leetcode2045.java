
// Tag - Medium

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        // build graph
        Map<Integer, List<Integer>> graph = new HashMap();
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph.computeIfAbsent(u,value->new ArrayList()).add(v);
            graph.computeIfAbsent(v,value->new ArrayList()).add(u);
        }

        // dijkstra's algorithm (to find 1st & 2nd shortest time)
        int[] dist1 = new int[n+1];
        int[] dist2 = new int[n+1];
        int[] freq = new int[n+1]; 

        Arrays.fill(dist1,Integer.MAX_VALUE);
        Arrays.fill(dist2,Integer.MAX_VALUE);

        // PriorityQueue keeps track of shortest time
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1]-b[1]);
        pq.offer(new int[]{1,0}); // {node, timeTaken}
        dist1[1] = 0;

        while(!pq.isEmpty()){
            int[] pair = pq.poll();
            int node = pair[0];
            int timeTaken = pair[1];

            freq[node]++;
            // base condition for ans
            if(freq[node] == 2 && node == n){
                return timeTaken;
            }
            // red signal 
            if((timeTaken/change)%2 == 1){
                timeTaken = change * (timeTaken/change+1) + time;
            }else{ // green signal
                timeTaken += time;
            }

            if(!graph.containsKey(node)){
                continue;
            }

            // explore neighbors & calculate top 2 shortest times (dist1 & dist2)
            for(int neighbor : graph.get(node)){
                if(freq[neighbor] == 2){
                    continue;
                }
                if(dist1[neighbor] > timeTaken){
                    dist2[neighbor] = dist1[neighbor];
                    dist1[neighbor] = timeTaken;
                    pq.offer(new int[]{neighbor, timeTaken});
                }else if(dist2[neighbor] > timeTaken && dist1[neighbor] != timeTaken){
                    dist2[neighbor] = timeTaken;
                    pq.offer(new int[]{neighbor, timeTaken});
                }
            }
        }
        return -1;
    }
}
