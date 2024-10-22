
// Tag - Medium

// TLE
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        return helper(0, s, new HashSet(wordDict));
    }
    private boolean helper(int i, String s, Set<Integer> dict){
        // base case
        if(i == s.length()){
            return true;
        }
        // loop through all possible substrings
        for(int j=i; j<s.length(); j++){
            // check if dict contains substring & next part is valid return true
            if(dict.contains(s.substring(i,j+1)) && helper(j+1,s,dict)){
                return true;
            }
        }
        return false;
    }
}

// memo
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        // init memo 
        Boolean[] memo = new Boolean[n];
        return helper(0, s, new HashSet(wordDict), memo);
    }
    private boolean helper(int i, String s, Set<Integer> dict, Boolean[] memo){
        // base case
        if(i == s.length()){
            return true;
        }
        // cached ? just return
        if(memo[i] != null){
            return memo[i];
        } 
        // loop through all possible substrings
        for(int j=i; j<s.length(); j++){
            // check if dict contains substring & next part is valid return true
            if(
                dict.contains(s.substring(i,j+1)) && 
                helper(j+1 ,s ,dict ,memo)
            ){
                return true;
            }
        }
        // cache & return
        return memo[i] = false;
    }
}