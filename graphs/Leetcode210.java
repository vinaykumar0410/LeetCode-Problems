
// Tag - Medium

class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // basic topological sort
        int[] ans = new int[numCourses];
        int[] indegree = new int[numCourses];
        // build graph using input nodes (coordinates here it is prerequisites)
        List<List<Integer>> graph = new ArrayList();
        // init adjacency list of size numCourses
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList());
        }
        // 0->1 (v -> u)
        for(int[] prerequisite : prerequisites){
            int u = prerequisite[0]; //  1
            int v = prerequisite[1]; // 0
            // indegree represents no of incoming edges of a node
            indegree[u]++;
            graph.get(v).add(u);
        }
        // add all the nodes with 0 degree(independent course actually) to queue
        Queue<Integer> q = new LinkedList();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        // index i helps to fill the output array sorted in topological order
        int i = 0;
        // process each node in the queue
        while(!q.isEmpty()){
            // add currCourse to output array as it is not dependent on other courses
            int currCourse = q.poll();
            ans[i++] = currCourse;
            // check it's neighbors actually dependent courses
            for(int dependentCourse : graph.get(currCourse)){
                // as one of its dependent course completed (where? Line32)
                // check indegree of dependent course by reducing 1 degree
                if(--indegree[dependentCourse] == 0){
                    // why? (Line20)
                    q.offer(dependentCourse); 
                }
            }
        }
        // cycle found return empty array
        if(i != numCourses){
            return new int[]{};
        }
        // no cycle found return array sorted in topological order
        return ans;
    }
}
