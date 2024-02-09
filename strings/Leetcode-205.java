

// Tag - Easy
class Solution {
    public boolean isIsomorphic(String s, String t) {

        // Create a hashmap to store mappings between characters of 's' and 't'.
        Map<Character,Character> map = new HashMap<>();

        // Iterate through the characters of string 's'.
        for(int i=0; i<s.length(); i++){
            char key = s.charAt(i);
            // If the current character from 's' is already mapped to a different character in 't'.
            if(map.containsKey(key)){
                // Get the existing value mapped to the current character in 's'.
                char existingValue = map.get(key);
                // Get the corresponding character from 't'.
                char currentValue = t.charAt(i);
                // If the existing value is not the same as the current value in 't', return false.
                if(existingValue != currentValue) return false;
            }else{
                // If the current character from 's' is not already mapped.
                char value = t.charAt(i);
                // Check if the current value is already mapped to a different key, which would violate uniqueness.
                if(map.containsValue(value)) return false;
                // Map the current character from 's' to the corresponding character from 't'.
                map.put(key,value);
            }
        }

        // If all characters in 's' can be mapped to corresponding characters in 't' without violation, return true.
        return true;
    }
}
