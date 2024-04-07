
// Tag - Easy

class Solution {
    public boolean isValid(String s) {
        // Initialize a stack to store opening parentheses
        Stack<Character> stack = new Stack<>(); 
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            
            if (ch == '(' || ch == '{' || ch == '[') {
                // If the character is an opening parenthesis, push it onto the stack
                stack.push(ch); 
            } else {
                // If the character is a closing parenthesis
                if (stack.isEmpty()) 
                    return false; // If the stack is empty, there's no corresponding opening parenthesis, so return false
                else {
                    // Get the top character from the stack
                    char top = stack.peek(); 
                    // Check if the current closing parenthesis matches the corresponding opening parenthesis
                    if ((ch == ')' && top == '(') || (ch == '}' && top == '{') || (ch == ']' && top == '[')) {
                        stack.pop(); // If so, pop the opening parenthesis from the stack
                    } else {
                        return false; // If not, return false
                    }
                }
            }
        }
        
        // Return true if the stack is empty (all opening parentheses are matched)
        return stack.isEmpty(); 
    }
}
