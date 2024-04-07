
// Tag - Medium

class Solution {
    public boolean checkValidString(String s) {
        int openCountMin = 0; // Minimum possible count of open parentheses
        int openCountMax = 0; // Maximum possible count of open parentheses
        
        // Iterate through each character in the string
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                openCountMax++; // Increment the maximum count of open parentheses
                openCountMin++; // Increment the minimum count of open parentheses
            } else if (ch == ')') {
                openCountMax--; // Decrement the maximum count of open parentheses
                openCountMin--; // Decrement the minimum count of open parentheses
            } else if (ch == '*') {
                openCountMax++; // Increment the maximum count of open parentheses
                openCountMin--; // Decrement the minimum count of open parentheses
            }
            
            // If the maximum count of open parentheses becomes negative, return false
            if (openCountMax < 0) 
                return false;
            
            // Ensure that the minimum count of open parentheses is non-negative
            openCountMin = Math.max(openCountMin, 0);
        }
        
        // If the minimum count of open parentheses is 0, return true, otherwise return false
        return openCountMin == 0;
    }
}


/*

class Solution {
    public boolean checkValidString(String s) {
        Stack<Integer> openStack = new Stack<>(); // Stack to store indices of '(' characters
        Stack<Integer> starStack = new Stack<>(); // Stack to store indices of '*' characters
        
        // Iterate through each character in the string
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                openStack.push(i); // If the character is '(', push its index onto the openStack
            } else if (ch == '*') {
                starStack.push(i); // If the character is '*', push its index onto the starStack
            } else {
                if (openStack.isEmpty() && starStack.isEmpty()) {
                    return false; // If there's no '(' or '*' to match the current ')', return false
                }
                if (!openStack.isEmpty()) {
                    openStack.pop(); // Pop the top '(' index from openStack if available
                } else {
                    starStack.pop(); // Pop the top '*' index from starStack if no '(' is available
                }
            }
        }
        
        // Process any remaining '(' and '*' characters
        while (!openStack.isEmpty() && !starStack.isEmpty()) {
            if (openStack.pop() > starStack.pop()) {
                return false; // If a '(' index is greater than a '*' index, return false
            }
        }
        
        // If openStack is empty, all '(' characters are matched by '*' or ')', return true
        return openStack.isEmpty(); 
    }
}

*/
