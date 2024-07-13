
// Tag - Medium

class Solution {
    public int maximumGain(String s, int x, int y) {
        if(x > y){
            // cal high score first and low score next
            return helper(s,'a','b',x,y);
        }
        return helper(s,'b','a',y,x);
    }
    private int helper(String s,char first,char second,int high,int low){
        int ans = 0;
        Stack<Character> stack = new Stack();
        // consider high score
        for(char ch : s.toCharArray()){
            if(!stack.isEmpty() && stack.peek()==first && ch==second){
                ans += high;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        StringBuilder rem = new StringBuilder();
        while(!stack.isEmpty()){
            rem.append(stack.pop());
        }
        // consider low score
        for(char ch : rem.toString().toCharArray()){
            if(!stack.isEmpty() && stack.peek()==first && ch==second){
                ans += low;
                stack.pop();
            }else{
                stack.push(ch);
            }
        }
        return ans;
    }
}