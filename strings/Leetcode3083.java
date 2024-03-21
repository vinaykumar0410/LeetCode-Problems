
// Tag - Easy
class Solution {
    public boolean isSubstringPresent(String s) {
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        // Reverse the original string.
        String reversedString = sb.reverse().toString();
        // Iterate through the original string to find substrings of length 2.
        for(int i=0; i<s.length()-1; i++){
            // Check if the reversed string contains the substring.
            if(reversedString.contains(s.substring(i,i+2))) 
                return true; // If found, return true.
        }
        return false; // Otherwise, return false.
    }
}
