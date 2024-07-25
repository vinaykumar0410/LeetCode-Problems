
// Tag - Medium

class Solution {
    public boolean doesAliceWin(String s) {
        int cnt = 0;
        // found vowel Alice will win else bob will win (no need cnt)
        for(int i=0; i<s.length(); i++){
            if(isVowel(s.charAt(i))){
                cnt++;
            }
            if(cnt > 0){
                return true;
            }
        }
        return false;
    }
    boolean isVowel(char ch){
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u';
    }
}
