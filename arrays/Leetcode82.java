
// Tag - Hard

class Solution {
    public int largestRectangleArea(int[] heights) {
        // Create a stack to store indices of heights
        Stack<Integer> stack = new Stack<>();
        // Initialize the maximum area
        int max = 0; 
        // Initialize an index for iterating through heights
        int i = 0; 
        
        // Iterate through the heights array
        while (i < heights.length) {
            // If the stack is empty or the current height is greater than or equal to the height at the top of the stack
            if (stack.isEmpty() || heights[i] >= heights[stack.peek()]) {
                // Push the current index onto the stack and move to the next index
                stack.push(i++); 
            } else {
                // Pop the index of the height at the top of the stack
                int top = stack.pop(); 
                // Get the height corresponding to the popped index
                int height = heights[top]; 
                // Calculate the width of the rectangle
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                // Calculate the area of the rectangle
                int area = height * width;
                // Update the maximum area
                max = Math.max(max, area);
            }
        }

        // Process remaining elements in the stack
        while (!stack.isEmpty()) {
             // Pop the index of the height at the top of the stack
            int top = stack.pop();
            // Get the height corresponding to the popped index
            int height = heights[top]; 
            // Calculate the width of the rectangle
            int width = stack.isEmpty() ? i : i - stack.peek() - 1;
            // Calculate the area of the rectangle
            int area = height * width;
            // Update the maximum area
            max = Math.max(max, area);
        }
        // Return the maximum area
        return max;
    }
}

