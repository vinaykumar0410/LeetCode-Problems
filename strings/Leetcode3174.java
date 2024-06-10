
// Tag - Easy

class Solution {
    public String clearDigits(String s) {
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            // digit found remove last char
            if(Character.isDigit(ch)){
                if(!stack.isEmpty()){
                    stack.pop();
                }
            }else{
                // add non digit
                stack.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        // append chars from stack
        while(!stack.isEmpty()){
            sb.append(stack.pop());
        }
        return sb.reverse().toString();
    }
}