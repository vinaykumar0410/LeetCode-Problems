
// Tag - Easy
class Solution {
    public int lengthOfLastWord(String s) {
        // Remove leading and trailing whitespace
        s = s.trim(); 
        // Start from the end of the string
        int i = s.length() - 1; 
        // Initialize the length of the last word
        int length = 0; 
        // Iterate backwards until a space character is found or the beginning of the string is reached
        while (i >= 0 && s.charAt(i) != ' ') {
            length++; // Increment the length for each character
            i--; // Move to the previous character
        }
        // Return the length of the last word
        return length; 
    }
}
