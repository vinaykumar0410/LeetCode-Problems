
// Tag - Medium

class Solution {
    public int maxUniqueSplit(String s) {
        // call helper method for max unique splits
        return helper(0, s, new HashSet());
    }
    private int helper(int i, String s, Set<String> set){
        // base case
        if(i >= s.length()){
            return 0;
        }
        // init maxCnt & loop through each substring
        int maxCnt = 0;
        for(int j=i; j<s.length(); j++){
            // take out substring
            String word = s.substring(i, j+1);
            // if substring not in set, add it to set & call helper & backtrack
            if(!set.contains(word)){
                set.add(word);
                maxCnt = Math.max(maxCnt, 1 + helper(j+1, s, set));
                set.remove(word);
            }
        }
        // return maxCnt
        return maxCnt;
    }
}