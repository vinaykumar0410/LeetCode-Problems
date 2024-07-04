
// Tag - Medium

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack();
        for(int asteroid : asteroids){
            boolean destroyed = false;
            // prev asteroid is pos and curr asteroid is neg (collision)
            while(!stack.isEmpty() && stack.peek() > 0 && asteroid < 0){
                int sum = stack.peek() + asteroid;
                // sum equals 0 means both will destroy
                if(sum == 0){
                    stack.pop();
                    destroyed = true;
                    break;
                }else if(sum > 0){ // pos asteroid won neg asteroid destroyed
                    destroyed = true; 
                    break;
                }else{ // neg asteroid won so prev pos asteroid will destroy
                    stack.pop();
                }
            }
            // no collision happens
            if(!destroyed) stack.push(asteroid);
        }
        // convert stack to list
        int[] ans = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.pop();
        }
        return ans;
     }
}