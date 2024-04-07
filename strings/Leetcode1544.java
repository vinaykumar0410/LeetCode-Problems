
// Tag - Easy

class Solution {
    public String makeGood(String s) {
        Stack<Character> stack = new Stack<>(); // Initialize a stack to store characters
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            // If the stack is not empty and the current character is the opposite case of the top character in the stack
            if (!stack.isEmpty() && Math.abs(stack.peek() - ch) == 32) {
                stack.pop(); // Remove the top character from the stack
            } else {
                stack.push(ch); // Otherwise, push the current character onto the stack
            }
        }
        
        // Initialize a StringBuilder to construct the result string
        StringBuilder sb = new StringBuilder(); 
        
        // Append characters from the stack to the StringBuilder
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        
        // Reverse the StringBuilder and convert it to a string
        return sb.reverse().toString(); 
    }
}
