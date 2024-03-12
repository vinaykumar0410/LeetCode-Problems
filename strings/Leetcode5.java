
// Tag - Medium
class Solution {
    public String longestPalindrome(String s) {
        // Variable to store the longest palindrome substring.
        String result = ""; 
        // Length of the longest palindrome substring found.
        int length = 0; 
        
        // Iterate through each character of the string.
        for (int i = 0; i < s.length(); i++) {
            int left = i; // Left pointer for expanding the palindrome substring leftside.
            int right = i; // Right pointer for expanding the palindrome substring rightside.
            
            // Expand around the current character to find palindrome substring with odd length.
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // If the current substring is longer than the previous longest palindrome, update result and length.
                if (right - left + 1 > length) {
                    result = s.substring(left, right + 1);
                    length = right - left + 1;
                }
                left--;
                right++;
            }
            
            left = i; // Reset left pointer.
            right = i + 1; // Adjust right pointer for finding palindrome substring with even length.
            
            // Expand around the current and next characters to find palindrome substring with even length.
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                // If the current substring is longer than the previous longest palindrome, update result and length.
                if (right - left + 1 > length) {
                    result = s.substring(left, right + 1);
                    length = right - left + 1;
                }
                left--;
                right++;
            }
        }
        
        return result; // Return the longest palindrome substring found.
    }
}
