
// Tag - Medium

class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        // There might be 2 possibilities take out max of them
        return Math.max(helper(answerKey,k,'T'),helper(answerKey,k,'F'));
    }
    int helper(String answerKey, int k,char ch){
        int ans = 0;
        int cnt = 0;
        int l = 0;
        // traverse input string
        for(int r=0; r<answerKey.length(); r++){
            // found target char increment cnt 
            if(answerKey.charAt(r) == ch){
                cnt++;
            }
            // cnt exceeds k (invalid case)
            while(cnt > k){
                // found target char decrement cnt 
                if(answerKey.charAt(l) == ch){
                    cnt--;
                }
                l++;
            }
            // cal max length of valid case
            ans = Math.max(ans,r-l+1);
        }
        return ans;
    }
}
