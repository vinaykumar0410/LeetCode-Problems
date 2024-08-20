
// Tag - Easy

class Solution {
    public int countKConstraintSubstrings(String s, int k) {
        int cnt = 0;
        for(int i=0; i<s.length(); i++){
            int zeros = 0;
            int ones = 0;
            for(int j=i; j<s.length(); j++){
                if(s.charAt(j) == '1') {
                    ones++;
                }else{
                    zeros++;
                }
                // found 0s or 1s atmost k count them
                if(zeros <= k || ones <= k) {
                    cnt++;
                }else{
                    break; 
                }
            }
        }
        return cnt;
    }
}