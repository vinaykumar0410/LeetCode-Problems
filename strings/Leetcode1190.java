
// Tag - Medium

class Solution {
    public String reverseParentheses(String s) {
        // better to manipulate array elements instead String
        char[] charArray = s.toCharArray();
        // stack holds index points of ( or )
        Stack<Integer> stack = new Stack();
        for(int end=0; end<s.length(); end++){
            // found opening (start point)
            if(s.charAt(end) == '('){
                stack.push(end); 
            }else if(s.charAt(end) == ')'){ // found closing (end point)
                int start = stack.pop()+1; 
                // why +1 dont want to deal with brackets while reversing
                reverse(charArray,start,end);
            }
        }
        return trimBrackets(charArray);
    }
    // function to reverse chars in an char array
    private void reverse(char[] charArray,int start,int end){
        while(start < end){
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;
            start++;
            end--;
        }
    }
    // function to eliminate brackets 
    private String trimBrackets(char[] charArray){
        for(int i=0; i<charArray.length; i++){
            // found opening or closing mark it as something
            if(charArray[i] == '(' || charArray[i] == ')'){
                 charArray[i] = '#';
            }
        }
        // later replace somthing with empty
        return new String(charArray).replaceAll("#","");
    }
}