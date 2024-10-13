
// Tag - Medium

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // init dp array
        int[][] dp = new int[m+1][n+1];
        // find longest common subsequence length
        int lcs = 0;
        for(int i=1; i<=m; i++){
            for(int j=1; j<=n; j++){
                // check if chars match
                if(word1.charAt(i-1) == word2.charAt(j-1)){
                    // increment with previous value present at (i-1,j-1)
                    dp[i][j] = 1 + dp[i-1][j-1];
                }else{
                    // if not match, take max of previous value
                    dp[i][j] = Math.max(dp[i][j-1],dp[i-1][j]);
                }
                // calculate longest common subsequence
                lcs = Math.max(lcs,dp[i][j]);
            }
        }
        // reduce longest common subsequence twice from from total length
        return m+n-(2*lcs);
    }
}
