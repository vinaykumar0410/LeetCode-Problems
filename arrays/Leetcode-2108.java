
// Tag - Easy
class Solution {
    public String firstPalindrome(String[] words) {
        // Iterate through each word in the array
        for (String word : words) {
            // Check if the word is a palindrome
            if (isPalindrome(word)) return word; // Return the word if palindrome is found
        } 
        return ""; // Return empty string if no palindrome is found
    }
    
    public boolean isPalindrome(String word) {
        int start = 0; // Pointer to the start of the word
        int end = word.length() - 1; // Pointer to the end of the word

        // Loop until start pointer is less than end pointer
        while (start < end) {
            // If characters at start and end pointers are not equal, return false
            if (word.charAt(start) != word.charAt(end)) return false;
            // Move start pointer forward and end pointer backward
            start++;
            end--;
        }

        return true; // Return true if the word is a palindrome
    }
}
