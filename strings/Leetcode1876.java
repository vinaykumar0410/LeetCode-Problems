
// Tag - Easy

class Solution {
    public int countGoodSubstrings(String s) {
        int goodSubstrings = 0;
        int l = 0;
        int r = 0;
        int[] freq = new int[26];
        while(r<s.length()){
            char rightChar = s.charAt(r);
            freq[rightChar-'a']++;
            if(r-l+1 > 3){
                char leftChar = s.charAt(l);
                freq[leftChar-'a']--;
                l++;
            }
            if(r-l+1 == 3){
                int cnt = 0;
                for(int i=0; i<26; i++){
                    if(freq[i] == 0){
                        continue;
                    }
                    if(freq[i] > 0){
                        cnt++;
                    }
                    if(cnt > 3){
                        break;
                    }
                }
                if(cnt == 3){
                    goodSubstrings++;
                }
            }
            r++;
        }
        return goodSubstrings;
    }
}