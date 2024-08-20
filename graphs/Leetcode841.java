
// Tag - Medium

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        // basic bfs
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        // to keep track of visited or not
        boolean[] visited = new boolean[rooms.size()];
        visited[0] = true;
        // process until queue becomes empty
        while(!q.isEmpty()){ 
            // poll out node from queue
            int key = q.poll();
            // mark neighbors as visited & add it to queue if not visited 
            for(int neighbor : rooms.get(key)){
                if(!visited[neighbor]){
                    q.offer(neighbor);
                    visited[neighbor] = true;
                }
            }
        }
        // if any one of the node is not visited (can't visit all rooms)
        for(int i=0; i<visited.length; i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
}