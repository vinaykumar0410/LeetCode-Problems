
// Tag - Medium
class Solution {
    // Counts the number of substrings in string s that consist of character c.
    public long countSubstrings(String s, char c) {
        int cnt = 0;
        // Count the occurrences of character c in the string.
        for(char ch : s.toCharArray()){
            if(ch == c) cnt++;
        }
        // Calculate the number of substrings using the formula n*(n+1)/2.
        return (long) cnt * (cnt + 1) / 2;
    }
}
