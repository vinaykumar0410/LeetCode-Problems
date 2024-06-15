
// Approach-1
// Tag - Easy
class Solution {
    public boolean halvesAreAlike(String s) {
        // 2 pointer approach
        // i moves forwards covering first half of the input String
        int i = 0;
        // j moves backwards covering second half of the input String
        int j = s.length()-1;
        // input String is a combination of both Upper and Lower case letters
        s = s.toLowerCase();
        // counters for both first and second half Strings
        int firstHalfVowels = 0;
        int secondHalfVowels = 0;
        while(i < j){
            // take out both chars at a time from first and second String
            char start = s.charAt(i);
            char end = s.charAt(j);
            // check if they are vowels if so increment respective counters
            if(isVowel(start)) firstHalfVowels++;
            if(isVowel(end)) secondHalfVowels++;
            // irrespective of above conditions both pointers should to be incremented
            i++;
            j--;
        }
        // return comparing them
        return firstHalfVowels == secondHalfVowels;
    }
    // method to check vowel
    boolean isVowel(char ch){
        return (ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u');
    }
}


// Approach-2

class Solution {
    public boolean halvesAreAlike(String s) {
        // calculate mid
        int mid = s.length()/2;
        // take out both Strings using mid index
        String firstHalf = s.substring(0,mid);
        String secondHalf = s.substring(mid);
        // call count vowels method and compare them
        return countVowels(firstHalf) == countVowels(secondHalf);
    }
    int countVowels(String string){
        int count = 0;
        // it will count the vowels in String
        for(char ch : string.toCharArray()){
            if("AEIOUaeiou".indexOf(ch) != -1) count++;
        }
        return count;
    }
}
