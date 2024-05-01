
// Tag - Easy
class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        int cnt = 0;
        for(String word : words){
            // found is keep track of not allowed char
            boolean found = true;
            for(char ch : word.toCharArray()){
                // found char that is not allowed inconsistent string found
                if(!allowed.contains(ch+"")) found = false;
            }
            // found still true consistent string found
            if(found) cnt++;
        }
        return cnt;
    }
}