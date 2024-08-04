
// Tag - Medium

class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        // create dp array & init with -1's
        int[] dp = new int[books.length];
        Arrays.fill(dp,-1);
        // call helper method for min possible height
        return helper(0,books,shelfWidth,dp);
    }
    private int helper(int i,int[][] books,int maxWidth,int[] dp){
        // base condition
        if(i >= books.length){
            return 0; 
        }
        // already computed before? then use it
        if(dp[i] != -1){
            return dp[i];
        }
        // not computed? compute now!
        int currWidth = 0;
        int maxHeight = 0;
        int ans = Integer.MAX_VALUE; // minimise the possiblity
        // traverse books
        for(int j=i; j<books.length; j++){
            // calculate width 
            currWidth += books[j][0];
            // currWidth exceeds maxWidth can't place current book break loop
            if(currWidth > maxWidth){
                break;
            }
            // calculate maxHeight with currHeight
            maxHeight = Math.max(maxHeight,books[j][1]);
            // calculate min possible ans with max height + next books height
            ans = Math.min(ans, maxHeight + helper(j+1,books,maxWidth,dp));
        }
        // store & return ans
        return dp[i] = ans;
    }
}