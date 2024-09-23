
// Tag - Medium


// TLE
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        Set<String> dict = new HashSet();
        // for searching in constant time
        for(String word : dictionary){
            dict.add(word);
        } 
        return helper(0, s, dict);
    }
    private int helper(int i,String s, Set<String> dict){
        // base case
        if(i == s.length()){
            return 0;
        }
        int extra = 1 + helper(i+1, s, dict); // skip 
        for(int j=i; j<s.length(); j++){
            // take works only when dict contains word
            if(dict.contains(s.substring(i, j+1))){
                extra = Math.min(extra, helper(j+1, s, dict));
            } 
        }
        return extra;
    }
}

// memo
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet();
        // for searching in constant time
        for(String word : dictionary){
            dict.add(word);
        } 
        // memo is to store computed values
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return helper(0, s, dict, memo);
    }
    private int helper(int i,String s, Set<String> dict, int[] memo){
        // base case
        if(i == s.length()){
            return 0;
        }
        // already computed just return that
        if(memo[i] != -1){
            return memo[i];
        } 
        int extra = 1 + helper(i+1, s, dict, memo); // skip 
        for(int j=i; j<s.length(); j++){
            // take works only when dict contains word
            if(dict.contains(s.substring(i, j+1))){
                extra = Math.min(extra, helper(j+1, s, dict, memo));
            } 
        }
        // store & return
        return memo[i] = extra;
    }
}

// tabulation
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dict = new HashSet();
        // for searching in constant time
        for(String word : dictionary){
            dict.add(word);
        } 
        // dp is to store previous computed values
        int[] dp = new int[n+1];
        // empty string dont have extra chars
        dp[n] = 0;
        for(int i=n-1; i>=0; i--){
            int extra = 1 + dp[i+1]; // skip 
            for(int j=i; j<s.length(); j++){
                // take works only when dict contains word
                if(dict.contains(s.substring(i, j+1))){
                    extra = Math.min(extra, dp[j+1]);
                } 
            }
            // store & return
            dp[i] = extra;
        }
        return dp[0];
    }
}