
// Tag - Easy

class Solution {
    public int longestPalindrome(String s) {
        Set<Character> set = new HashSet();
        int cnt = 0;
        for(char ch : s.toCharArray()){
            // palindrome found
            if(set.contains(ch)){
                set.remove(ch);
                cnt++;
            }else{
                set.add(ch);
            }
        }
        // odd length palindrome so add +1
        if(!set.isEmpty()) return cnt*2+1;
        // even length palindrome 
        return cnt*2;
    }
}