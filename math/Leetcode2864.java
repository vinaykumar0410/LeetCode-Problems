
// Tag - Easy
class Solution {
    public String maximumOddBinaryNumber(String s) {
        // Count of '1's in the string.
        int ones = 0; 
        // Count of '0's in the string.
        int zeros = 0; 

        // Count '1's and '0's in the string.
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '1') ones++;
            else zeros++;
        }

        // StringBuilder to construct the result.
        StringBuilder sb = new StringBuilder(); 

        // Append '1's based on the count of '1's in the string.
        for(int i=0; i<ones-1; i++) sb.append("1");

        // Append '0's based on the count of '0's in the string.
        for(int i=0; i<zeros; i++) sb.append("0");

        // Append one more '1' to make it an odd binary number.
        sb.append("1"); 
        
        return sb.toString(); // Return the constructed maximum odd binary number.
    }
}
