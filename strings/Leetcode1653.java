
// Tag - Medium

// TC - O(n)
// SC - O(1)
class Solution {
    public int minimumDeletions(String s) {
        int deletions = 0;
        int bCount = 0;
        for(char ch : s.toCharArray()){
            if(ch == 'b'){
                bCount++;
            }else{
                if(bCount > 0){
                    bCount--;
                    // deletions of b occurred before a
                    deletions++;
                }
            }
        }
        return deletions;
    }
}

// TC - o(n)
// SC - O(n)
class Solution {
    public int minimumDeletions(String s) {
        int deletions = 0;
        Stack<Character> stack = new Stack();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // stack is not empty & found b at top of stack
            if(!stack.isEmpty() && stack.peek() == 'b'){
                // current char is 'a' ("ba" found delete 'b', skip 'a')
                if(ch == 'a'){
                    stack.pop(); // 'b' deleted
                    deletions++; 
                }else{
                    // current char is not 'a' push it to stack
                    stack.push(ch);
                }
            }else{
                // stack is empty push it
                stack.push(ch);
            }
        }
        return deletions;
    }
}