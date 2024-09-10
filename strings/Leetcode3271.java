
// Tag - Medium

class Solution {
    public String stringHash(String s, int k) {
        StringBuilder ans = new StringBuilder();
        for(int i=0; i<s.length(); i+=k){
            int sum = 0;
            // extract substring of length k
            String substring = s.substring(i,i+k);
            // calculate sum of decoded value of characters
            for(char ch : substring.toCharArray()){
                sum += ch-'a'; // a->0, b->1, ...., z->25
            }
            // sum is converted to char again (sum may exceed 25 so we take mod 26)
            ans.append((char)((sum%26)+'a')); 
        }
        return ans.toString();
    }
}