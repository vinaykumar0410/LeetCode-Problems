
// Tag - Medium
class Solution {
    public int minimumLength(String s) {

        // Initialize two pointers i and j using the 2-pointer approach.
        int i = 0;
        int j = s.length() - 1;

        // Move pointers towards each other until different characters are found or they meet.
        while (i < j && s.charAt(i) == s.charAt(j)) {
            char ch = s.charAt(i);
            // Move i to the right while characters match.
            while (i < j && s.charAt(i) == ch) i++; 
            // Move j to the left while characters match.
            while (i <= j && s.charAt(j) == ch) j--; 
        }

        // Return the length of the remaining substring.
        return j - i + 1;
    }
}
