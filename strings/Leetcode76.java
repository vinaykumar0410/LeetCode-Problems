
// Tag - Hard
class Solution {
    public String minWindow(String s, String t) {
        // Check if either of the strings are empty, if so, return an empty string.
        if(s.length() == 0 || s == null || t.length() == 0 || t == null){
            return "";
        }

        // Create a hashmap to store the frequency of characters in string 't'.
        Map<Character,Integer> map = new HashMap<>();

        // Populate the hashmap with characters from string 't'.
        for(char ch : t.toCharArray()){
            map.put(ch,map.getOrDefault(ch,0)+1);
        }

        // Initialize pointers and variables for tracking the window.
        int i = 0;
        int j = 0;
        int left = 0;
        int right = s.length()-1;
        int minLength = s.length();
        boolean found = false;
        int count = map.size();

        // Iterate through the string 's'.
        while(j < s.length()){
            // Expand the window by moving the right pointer and update the frequency map.
            char endChar = s.charAt(j++);
            if(map.containsKey(endChar)){
                map.put(endChar,map.get(endChar)-1);
                if(map.get(endChar) == 0) count--;
            }

            // If all characters in 't' are found in the window, try to minimize the window.
            if(count > 0) continue;

            // Shrink the window by moving the left pointer and update the frequency map.
            while(count == 0){
                char startChar = s.charAt(i++);
                if(map.containsKey(startChar)){
                    map.put(startChar,map.get(startChar)+1);
                    if(map.get(startChar) > 0) count++;
                }
            }

            // Calculate the current window length and update the minimum window if necessary.
            int currentLength = j-i;
            if(currentLength < minLength){
                left = i;
                right = j;
                minLength = currentLength;
                found = true;
            }
        }
        // Return the minimum window substring if found, otherwise return an empty string.
        return found ? s.substring(left-1,right) : "";
    }
}
