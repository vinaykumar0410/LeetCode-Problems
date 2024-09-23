
// Tag - Hard

class Solution {
    public String shortestPalindrome(String s) {
        // Try to find the longest palindrome starting at index 0
        int n = s.length();
        for(int i = n - 1; i >= 0; i--) {
            if(isPalindrome(s, 0, i)) {
                // Find the longest palindrome starting at index i+1
                String suffix = s.substring(i + 1);
                // Reverse suffix
                String reversedSuffix = new StringBuilder(suffix).reverse().toString();
                // Prepend suffix to original string
                return reversedSuffix + s;
            }
        }
        return "";
    }

    private boolean isPalindrome(String s, int i, int j) {
        // Check if s[i:j+1] is a palindrome
        while(i < j) {
            if(s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}

class Solution {
    public String shortestPalindrome(String s) {
        int n = s.length();
        if(n == 0) return s;

        // Find the longest prefix that is a palindrome
        int left = 0;
        for(int right = n-1; right >= 0; right--){
            if(s.charAt(left) == s.charAt(right)){
                left++;
            }
        }

        // If the whole string is a palindrome, return it
        if(left == n) return s;

        // Reverse the suffix and append it to the original string
        String suffix = s.substring(left);
        // Reverse suffix
        StringBuilder reversedSuffix = new StringBuilder(suffix).reverse();

        // Prepend suffix to original string
        return reversedSuffix
            .append(shortestPalindrome(s.substring(0,left)))
            .append(suffix)
            .toString();
    }
}