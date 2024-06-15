
// Tag - Easy
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {

        // Initialize an array to store the frequency of characters in 'magazine'.
        int[] charArray = new int[26];
        
        // Calculate the frequency of characters in 'magazine'.
        for(int i=0; i<magazine.length(); i++) charArray[magazine.charAt(i)-'a']++;
        
        // Iterate through each character in 'ransomNote'.
        for(int i=0; i<ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            // If the character's frequency in 'magazine' is not enough, return false.
            if(charArray[ch-'a'] == 0) 
                return false;
            // Decrement the character's frequency in 'charArray'.
            charArray[ch-'a']--;
        } 
        
        // All characters in 'ransomNote' can be constructed from 'magazine'.
        return true;
    }
}
