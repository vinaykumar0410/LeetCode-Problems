
// Tag - Hard

class Solution {
    public List<Integer> survivedRobotsHealths(int[] pos, int[] h, String dir) {
        // Create an array of indices and initialize it with 0 to pos.length - 1
        Integer[] list = new Integer[pos.length];
        for(int i = 0; i < pos.length; i++) list[i] = i;  
        
        // Sort the indices based on the positions of the robots
        Arrays.sort(list, (a, b) -> Integer.compare(pos[a], pos[b])); 
        
        // Stack to keep track of robots moving to the right ('R')
        Stack<Integer> stack = new Stack<>();
        
        // Process each robot in the sorted order of their positions
        for(int i : list) {
            // Push index of robot moving to the right
            if(dir.charAt(i) == 'R') {
                stack.push(i); 
                continue;
            } 
            // Process collisions for robots moving to the left ('L')
            while(!stack.isEmpty() && h[i] > 0) {
                // Robot in the stack is stronger
                if(h[stack.peek()] > h[i]) {
                    // Current robot is destroyed
                    h[i] = 0; 
                    // Reduce health of the robot in the stack
                    h[stack.peek()] -= 1; 
                } 
                // Current robot is stronger
                else if(h[stack.peek()] < h[i]) { 
                    // Reduce health of the current robot
                    h[i] -= 1; 
                    // Robot in the stack is destroyed
                    h[stack.pop()] = 0; 
                } else {
                    // Both robots have the same health
                    // Both robots are destroyed
                    h[i] = 0; 
                    h[stack.pop()] = 0; 
                }
            }
        }
        
        // Collect the healths of the robots that survived
        List<Integer> ans = new ArrayList<>();
        for(int v : h) if(v > 0) ans.add(v);
        return ans;
    }
}
