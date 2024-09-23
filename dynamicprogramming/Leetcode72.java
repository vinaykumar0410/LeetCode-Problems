
// Tag - Medium

class Solution {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        // memo is use to store already computed paths
        int[][] memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row, -1);
        }
        return helper(m-1, n-1, word1, word2, memo);
    }
    private int helper(int i,int j,String word1, String word2,int[][] memo){
        // base cases
        if(i < 0){
            return j+1;
        }
        if(j < 0){
            return i+1;
        }
        // already computed just return that
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // matching case
        if(word1.charAt(i) == word2.charAt(j)){
            return helper(i-1, j-1, word1, word2, memo);
        }
        // mismatch case
        int insert = 1 + helper(i, j-1, word1, word2, memo);
        int delete = 1 + helper(i- 1,j, word1, word2, memo);
        int replace = 1 + helper(i-1, j-1, word1, word2, memo);
        // store & return
        return memo[i][j] = Math.min(insert,Math.min(delete, replace));
    }
}