
// Tag - Easy
class Solution {
    public int maximumLengthSubstring(String s) {
        // Initialize the maximum length of the substring.
        int maxLength = 0;
        // Map to store the frequency of characters in the substring.
        Map<Character, Integer> map = new HashMap<>();
        // Initialize the left pointer.
        int left = 0;
        
        // Iterate through the string with the right pointer.
        for (int right = 0; right < s.length(); right++) {
            // Get the current character.
            char currentChar = s.charAt(right);
            // Update the frequency of the current character in the map.
            map.put(currentChar, map.getOrDefault(currentChar, 0) + 1);
            
            // If the map contains more than two distinct characters, move the left pointer.
            while (map.size() > 2) {
                char leftChar = s.charAt(left);
                // Decrease the frequency of the character at the left pointer.
                map.put(leftChar, map.get(leftChar) - 1);
                // If the frequency becomes 0, remove the character from the map.
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                // Move the left pointer to the right.
                left++;
            }
            
            // Update the maximum length of the substring.
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        // Return the maximum length of the substring.
        return maxLength;
    }
}
