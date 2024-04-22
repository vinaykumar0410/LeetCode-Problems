
// Tag - Easy

class Solution {
    public int scoreOfString(String s) {
        int sum = 0; 
        int first = s.charAt(0); 
        // Iterate through the string starting from the second character
        for(int i = 1; i < s.length(); i++){
            // Get the ASCII value of the current character
            int second = s.charAt(i); 
            // Add the absolute difference between the ASCII values to the sum
            sum += Math.abs(first - second); 
            // Update the 'first' variable for the next iteration
            first = second; 
        }
        // Return the final sum
        return sum; 
    }
}
