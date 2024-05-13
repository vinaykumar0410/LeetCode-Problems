
// Tag - Medium
class MinStack {
    int min = Integer.MAX_VALUE; // Initialize minimum value
    Stack<Integer> stack; // Declare stack to store elements

    public MinStack() { 
        stack = new Stack<>(); // Initialize stack
    }
    
    public void push(int val) {
        // If the new value is less than or equal to current min,
        // push current min onto stack and update min
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val); // Push the new value onto stack
    }
    
    public void pop() {
        // If the top element of stack is the current min,
        // pop it and update min to the next top element
        if (min == stack.pop()) min = stack.pop();
    }
    
    public int top() {
        return stack.peek(); // Return the top element of stack
    }
    
    public int getMin() {
        return min; // Return the current minimum element
    }
}
