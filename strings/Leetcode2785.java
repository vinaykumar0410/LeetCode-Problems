
// Tag - Medium

class Solution {
    public String sortVowels(String s) {
        // just take out all vowels to String then to Char array
        // sort them traverse input arr (actually String convert to arr)
        // then if found curr vowel replace with sorted vowel
        char[] arr = s.toCharArray();
        StringBuilder vowels = new StringBuilder();
        for(char ch : arr){
            if(isVowel(ch)){
                vowels.append(ch);
            } 
        } 
        char[] vowelsArr = vowels.toString().toCharArray();
        Arrays.sort(vowelsArr);
        int j = 0;
        for(int i=0; i<arr.length; i++){
            if(isVowel(arr[i])){
                arr[i] = vowelsArr[j++];
            } 
        }
        return new String(arr);
    }
    private boolean isVowel(char ch){
        // return "aeiou".contains(ch+"") || "AEIOU".contains(ch+"");
        return ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' ||
        ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U';
    }
}