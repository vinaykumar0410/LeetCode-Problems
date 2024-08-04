
// Tag - Medium
class Solution {
    public String decodeString(String s) {
        Stack<Character> stack = new Stack<>();
        // traverse input string
        for(char ch : s.toCharArray()){
            // push every character until u found closing bracket 
            if(ch != ']'){
                stack.push(ch);
            }else{
                // found closing bracket 
                StringBuilder curr = new StringBuilder();
                // form string until u found opening bracket
                while(!stack.isEmpty() && stack.peek() != '['){
                    curr.insert(0,stack.pop());
                }
                // pop out opening bracket
                stack.pop();
                // calculate cnt
                StringBuilder cnt = new StringBuilder();
                while(!stack.isEmpty() && Character.isDigit(stack.peek())){
                    cnt.insert(0,stack.pop());
                }
                int count = Integer.parseInt(cnt.toString());
                // multiply string cnt times & push back to stack
                while(count-->0){
                    for(char letter : curr.toString().toCharArray()){
                        stack.push(letter);
                    }
                } 
            }
        }
        StringBuilder ans = new StringBuilder();
        // take out output string
        while(!stack.isEmpty()){
            ans.insert(0,stack.pop());
        }
        return ans.toString();
    }
}