
// Tag - Medium

class Solution {
    public String repeatLimitedString(String s, int repeatLimit) {
        int[] freq = new int[26];
        for(char ch : s.toCharArray()){
            freq[ch-'a']++;
        }
        StringBuilder ans = new StringBuilder();
        int i = 25; 
        while(i >= 0){
            if(freq[i] == 0){
                i--;
                continue;
            }
            int min = Math.min(freq[i], repeatLimit);
            for(int j=0; j<min; j++){
                ans.append((char)('a'+i));
            }
            freq[i] -= min;
            if(freq[i] > 0){
                int prev = i-1;
                while(prev >= 0 && freq[prev] == 0){
                    prev--;
                }
                if(prev < 0){
                    break;
                }
                ans.append((char)('a'+prev));
                freq[prev]--;
            }
        }
        return ans.toString();
    }
}