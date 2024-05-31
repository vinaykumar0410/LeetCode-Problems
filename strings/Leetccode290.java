
// Tag - Easy
class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Split the string s into an array of words.
        String[] arr = s.split(" ");
        
        // If the lengths of pattern and arr are different, patterns can't match.
        if(pattern.length() != arr.length) 
            return false;
        
        // Initialize a map to store character-word pairs.
        Map<Character, String> map = new HashMap<>();
        
        // Iterate through each character in the pattern.
        for(int i=0; i<pattern.length(); i++){
            char ch = pattern.charAt(i);
            String currentValue = arr[i];
            
            // If the map doesn't contain the current character.
            if(!map.containsKey(ch)){ 
                // Check if the current value is already mapped to another character.
                if(map.containsValue(currentValue)) return false;
                // If not, map the character to the current value.
                else map.put(ch, currentValue);
            }
            // If the map contains the current character.
            else{  
                String existingValue = map.get(ch);
                // Check if the existing mapping matches the current value.
                if(!existingValue.equals(currentValue)) return false;
            }
        }

        return true;
    }
}

