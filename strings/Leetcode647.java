
// Tag - Medium
class Solution {
    public int countSubstrings(String str) {
        // Initialize the count of palindromes
        int palindromeCount = 0; 
        // Loop through each character in the string
        for (int i = 0; i < str.length(); i++) { 
            // Count palindromes with odd length, centered at character i
            palindromeCount += countPalindromes(str, i, i);
            // Count palindromes with even length, centered between characters i and i+1
            palindromeCount += countPalindromes(str, i, i + 1);
        }
        // Return the total count of palindromic substrings
        return palindromeCount; 
    }
  
    public int countPalindromes(String str, int start, int end) {
        // Initialize the count of palindromes
        int palindromeCount = 0; 
        while (start >= 0 && end < str.length() && str.charAt(start) == str.charAt(end)) {
            // Increment count when palindrome is found
            palindromeCount++; 
            start--; // Move start index towards left
            end++; // Move end index towards right
        }
        // Return the count of palindromes found
        return palindromeCount; 
    }
}
