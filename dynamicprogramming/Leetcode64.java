
// Tag - Medium

// Recursion 
class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return helper(grid,0,0,m,n);
    }
    private int helper(int[][] grid,int i,int j,int m,int n){
        // valid base case
        if(i == m-1 && j == n-1){
            return grid[i][j];
        }
        // invalid base case
        if(i == m || j == n){
            return Integer.MAX_VALUE;
        }
        // try all possible paths
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i+1 < m){
            down = helper(grid,i+1,j,m,n);
        }
        if(j+1 < n){
            right = helper(grid,i,j+1,m,n);
        }
        // return min path
        return grid[i][j] + Math.min(down,right);
    }
}

// Memoization

class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        // memo is used to store already computed min paths
        int[][] memo = new int[m][n];
        for(int[] row : memo){
            Arrays.fill(row,Integer.MAX_VALUE);
        }
        return helper(grid,0,0,m,n,memo);
    }
    private int helper(int[][] grid,int i,int j,int m,int n,int[][] memo){
        // valid base case
        if(i == m-1 && j == n-1){
            return grid[i][j];
        }
        // invalid base case
        if(i == m || j == n){
            return Integer.MAX_VALUE;
        }
        // already computed min path return that
        if(memo[i][j] != Integer.MAX_VALUE){
            return memo[i][j];
        }
        // try all possible paths
        int down = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        if(i+1 < m){
            down = helper(grid,i+1,j,m,n,memo);
        }
        if(j+1 < n){
            right = helper(grid,i,j+1,m,n,memo);
        }
        // store & return min path
        memo[i][j] = grid[i][j] + Math.min(down,right);
        return memo[i][j];
    }
}