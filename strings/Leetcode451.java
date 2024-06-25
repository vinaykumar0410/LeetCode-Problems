
// Tag - Medium
class Solution {
    public String frequencySort(String s) {

        // Array to store character frequencies.
        int[][] charFreq = new int[256][2];
        
        // Calculate frequencies of characters.
        for(int i=0; i<s.length(); i++){
            charFreq[s.charAt(i)][0] = s.charAt(i); // stores ASCII
            charFreq[s.charAt(i)][1]++; // stores it's frequency
        }
        
        // Sort characters based on frequency in descending order.
        Arrays.sort(charFreq, (a,b) -> (b[1] - a[1]));
            
        StringBuilder sb = new StringBuilder();
        
        // Build the sorted string.
        for(int i=0; i<charFreq.length; i++){
            // Append the character 'i' as many times as its frequency.
            while(charFreq[i][1]-- > 0){
               sb.append((char)charFreq[i][0]);
           }
        }
        
        return sb.toString();
    }
}

