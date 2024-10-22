
// Tag - Easy

class Solution {
    public int minLength(String s) {
        // Initialize a stack to store the characters
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // if stack is empty then push char to stack
            if(stack.isEmpty()){
                stack.push(ch);
            }else{
                // if stack is not empty then check if top of stack is A or B and char is C or D
                // if both are true then pop top of stack
                // else push char to stack
                char top = stack.peek();
                if(top == 'A' && ch == 'B' || top == 'C' && ch == 'D'){
                    stack.pop();
                }else{
                    stack.push(ch);
                }
            }
        }
        return stack.size();
    }
}