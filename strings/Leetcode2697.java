
// Tag - Easy
class Solution {
    public String makeSmallestPalindrome(String s) {
        // convert string to char array
        char[] arr = s.toCharArray();
        // two pointer (palindrome problem)
        int i = 0;
        int j = s.length()-1;
        // loop until i excceds j
        while(i < j){
            // found non palindrome and first char less than last
            if(arr[i] != arr[j] && arr[i] < arr[j]){ 
                // assign first char to last 
                // (why this bcoz in problem they asked for Lexicographically Smallest Palindrome)
                arr[j] = arr[i];
            }else{
                // assign last char to first 
                arr[i] = arr[j];
            }
            // moves pointers 
            i++;
            j--;
        }
        return new String(arr);
    }
}