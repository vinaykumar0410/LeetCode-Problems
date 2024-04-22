
// Tag - Medium
class Solution {
    public String removeKdigits(String num, int k) {
        // Stack to store digits
        Stack<Character> stack = new Stack<>(); 
        // Iterate through each character in the number
        for(char ch : num.toCharArray()){
            // While stack is not empty, k is not zero, and top of stack is greater than current character
            while(!stack.isEmpty() && k != 0 && stack.peek() > ch) {
                stack.pop(); // Pop elements from stack
                k--; // Decrement k
            }
            stack.push(ch); // Push current character onto stack
        }
        // If k is still not zero, pop elements from stack until k becomes zero
        while(!stack.isEmpty() && k != 0){
            stack.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        // Build the result string by popping elements from stack and appending to StringBuilder
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        // Reverse StringBuilder to get correct order of digits
        sb.reverse(); 
        // Remove leading zeros from the result
        while(sb.length() > 1 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }
        // Return the result string, or "0" if result is empty
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
