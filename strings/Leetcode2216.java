
// Tag - Easy
class Solution {
    public String getSmallestString(String s) {
        // convert to char array (why? easy to manipulate)
        char[] ans = s.toCharArray();
        for(int i=0; i<ans.length-1; i++){
            // first num > second num & both have same parity (swap & return)
            if(ans[i]-'0' > ans[i+1]-'0' && ans[i]%2 == ans[i+1]%2){
                char temp = ans[i];
                ans[i] = ans[i+1];
                ans[i+1] = temp;
                return new String(ans);
            }
        }
        return new String(ans);
    }
}