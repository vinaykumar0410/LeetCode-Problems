
// Tag - Easy

class Solution {
    public boolean isCircularSentence(String sentence) {
        char prev = sentence.charAt(sentence.length()-1);
        for(String curr : sentence.split(" ")){
            if(curr.charAt(0)!=prev){
                return false;
            }
            prev = curr.charAt(curr.length()-1);
        }
        return true;
    }
}