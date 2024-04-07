
// Tag - Easy

class Solution {
    public int maxDepth(String s) {
         // Initialize the maximum depth
        int ans = 0;
        Stack<Character> stack = new Stack<>(); // Initialize a stack to keep track of parentheses
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the character is an opening parenthesis, push it onto the stack
            if (ch == '(') {
                stack.push(ch); 
            } 
            // If the character is a closing parenthesis, pop the corresponding opening parenthesis from the stack
            else if (ch == ')') { 
                stack.pop(); 
            }
            // Update the maximum depth based on the size of the stack
            ans = Math.max(ans, stack.size()); 
        }
        return ans; // Return the maximum depth
    }
}
