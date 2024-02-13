
// Tag - Medium
class Solution {
    public int evalRPN(String[] tokens) {
        // Initialize a stack to store operands
        Stack<Integer> stack = new Stack();
        // Variables to store operands
        int num1, num2; 
        // Loop through each token in the input array
        for (String token : tokens) {
            // If the token is an operator, perform the operation on the operands
            if (token.equals("+")) {
                num2 = stack.pop();
                num1 = stack.pop();
                int sum = num1 + num2;
                stack.push(sum); // Push the result back to the stack
            } else if (token.equals("-")) {
                num2 = stack.pop();
                num1 = stack.pop();
                int difference = num1 - num2;
                stack.push(difference); // Push the result back to the stack
            } else if (token.equals("*")) {
                num2 = stack.pop();
                num1 = stack.pop();
                int product = num1 * num2;
                stack.push(product); // Push the result back to the stack
            } else if (token.equals("/")) {
                num2 = stack.pop();
                num1 = stack.pop();
                int quotient = num1 / num2;
                stack.push(quotient); // Push the result back to the stack
            } else { 
                // If the token is an operand, push it to the stack
                stack.push(Integer.parseInt(token));
            }
        }
        // Return the final result, which is the only element left in the stack
        return stack.pop();
    }
}
