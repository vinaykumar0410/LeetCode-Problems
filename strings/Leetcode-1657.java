
// Tag - Medium
class Solution {
    public boolean closeStrings(String word1, String word2) {

        // Initialize frequency arrays for each character in the alphabet
        int[] word1Freq = new int[26];

        // Count the occurrences of each character in the first word
        for (char ch : word1.toCharArray()) word1Freq[ch - 'a']++;
        
        int[] word2Freq = new int[26];
        // Count the occurrences of each character in the second word
        for (char ch : word2.toCharArray()) word2Freq[ch - 'a']++;

        // Check if the sets of characters in both words are the same
        // If a character is present in one word and not in the other, they are not "close"
        for (int i = 0; i < 26; i++) {
            if ((word1Freq[i] == 0 && word2Freq[i] != 0) ||
                (word1Freq[i] != 0 && word2Freq[i] == 0))
                return false;
        }

        // Sort the frequency arrays to compare the distribution of character frequencies
        Arrays.sort(word1Freq);
        Arrays.sort(word2Freq);
        
        // Check if the sorted frequency arrays are equal
        // If yes, the words are "close"; otherwise, they are not
        return Arrays.equals(word1Freq, word2Freq);
    }
}
