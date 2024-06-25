
// Tag - Medium
class Solution {
    public int minSteps(String s, String t) {
        int[] first = new int[26];
        for(char ch : s.toCharArray()){
            first[ch-'a']++;
        } 
        int[] second = new int[26];
        for(char ch : t.toCharArray()){
            second[ch-'a']++;
        } 
        int minimumSteps = 0;
        for(int i=0; i<26; i++){
            if(first[i]!=second[i]){
                minimumSteps += Math.abs(first[i]-second[i]);
            }
        }
        return minimumSteps;
    }
}