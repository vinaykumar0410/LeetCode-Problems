
// Tag - Medium
class Solution {
    public String customSortString(String order, String s) {
        // StringBuilder to construct the sorted string.
        StringBuilder sb = new StringBuilder(); 
        // Map to store character frequencies.
        Map<Character,Integer> map = new HashMap(); 
        
        // Count the frequencies of characters in the input string.
        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        
        // Iterate through the order string to maintain the given order.
        for (char ch : order.toCharArray()) {
            // If the character exists in the input string, append it according to its frequency.
            if (map.containsKey(ch)) {
                int count = map.get(ch);
                for (int i = 0; i < count; i++) {
                    sb.append(ch);
                    map.remove(ch); // Remove the character from the map after appending.
                }
            }
        }
        
        // Append remaining characters that are not in the order string.
        for (char ch : map.keySet()) {
            int count = map.get(ch);
            for (int i = 0; i < count; i++) {
                sb.append(ch);
            }
        }
        
        return sb.toString(); // Return the custom-sorted string.
    }
}
