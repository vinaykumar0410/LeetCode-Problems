
// Tag - Easy

class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Initialize a map to store character mappings
        Map<Character, Character> map = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            // If the character from s is not mapped yet
            if (!map.containsKey(s.charAt(i))) {
                // Get the character from s
                char key = s.charAt(i); 
                // Get the corresponding character from t
                char value = t.charAt(i); 
                // Check if the value is already mapped to another key
                if (map.containsValue(value)) return false; // If so, the mapping is not unique, return false
                map.put(key, value); // Otherwise, create a new mapping
            } else {
                // If the character from s is already mapped, check if the mapping matches t
                // Get the mapped character from s
                char ch = map.get(s.charAt(i)); 
                if (t.charAt(i) != ch) return false; // If the mapping doesn't match t, return false
            }
        }
        // If all characters are mapped correctly, return true
        return true; 
    }
}
