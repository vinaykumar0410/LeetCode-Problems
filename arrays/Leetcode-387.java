
// Tag - Easy
class Solution {
    public int firstUniqChar(String s) {

        // frequency matters
        int[] freq = new int[26];

        // populate freq array with frequency
        for(char ch : s.toCharArray()) freq[ch-'a']++;

        // traverse input array
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            // the 1st char found to be repeated once is the answer
            if(freq[ch-'a'] == 1) return i;
        }
        
        // not found no problem return -1
        return -1;
    }
}