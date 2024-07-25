
// Tag - Medium

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList();
        int[] indegree = new int[numCourses];
        for(int i=0; i<numCourses; i++){
            graph.add(new ArrayList());
        }
        // 1 -> 0 (before taking 1st course u have to take 0th course first)
        for(int[] prerequisite : prerequisites){
            int course = prerequisite[0];
            int preCourse = prerequisite[1];
            // course is dependent on preCourse 
            // so increment indegree of course
            indegree[course]++;
            graph.get(preCourse).add(course); // 0 -> 1
        }
        // add all courses that are independent (degree == 0)
        Queue<Integer> q = new LinkedList();
        // loop through indegree 
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.offer(i);
            }
        }
        // after while loop if cnt turns out to be 0 means we took all courses
        int cnt = numCourses;
        while(!q.isEmpty()){
            // poll out last node
            int currCourse = q.poll();
            // loop all depepended courses
            for(int dependedCourse : graph.get(currCourse)){
                // no more depended courses
                if(--indegree[dependedCourse] == 0){
                    // currCourse is done lets add depended course
                    q.offer(dependedCourse);
                }
            }
            cnt--; // took a course
        }
        return cnt == 0;
    }
}