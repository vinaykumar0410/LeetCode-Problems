
// Tag - Medium

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if(obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1){
            return 0;
        }
        // memo is use to store already computed paths
        int[][] memo = new int[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(memo[i],-1);
        }
        return helper(obstacleGrid,0,0,m,n,memo);
    }
    // Recursion with memoization
    private int helper(int[][] obstacleGrid,int i,int j,int m,int n,int[][] memo){
        // reached end return 1
        if(i == m-1 && j == n-1){
            return 1;
        }
        // invalid base case
        if(i == m || j == n || obstacleGrid[i][j] == 1){
            return 0;
        }
        // already computed just return that
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // try all possible paths
        int right = helper(obstacleGrid,i,j+1,m,n,memo);
        int down = helper(obstacleGrid,i+1,j,m,n,memo);
        // store & return path
        memo[i][j] = right + down;
        return memo[i][j];
    }
}