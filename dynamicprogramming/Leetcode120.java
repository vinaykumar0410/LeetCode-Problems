
// Tag - Medium

// Recursion
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        return dfs(0,0,triangle,n);
    }
    // helper method to try all possible paths
    private int dfs(int i,int j, List<List<Integer>> triangle, int n){
        // base case
        if(i == n-1){
            return triangle.get(i).get(j);
        }
        // try all possible paths
        int down = dfs(i+1,j,triangle,n);
        int downright = dfs(i+1,j+1,triangle,n);
        // return min path
        return triangle.get(i).get(j) + Math.min(down,downright);
    }
}

// Memoization
class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // memo is used to store already computed paths
        int[][] memo = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(memo[i],-1);
        }
        return dfs(0,0,triangle,n,memo);
    }
    private int dfs(int i,int j, List<List<Integer>> triangle, int n,int[][] memo){
        // base case
        if(i == n-1){
            return triangle.get(i).get(j);
        }
        // already computed just return that
        if(memo[i][j] != -1){
            return memo[i][j];
        }
        // try all possible paths
        int down = dfs(i+1,j,triangle,n,memo);
        int downright = dfs(i+1,j+1,triangle,n,memo);
        // return min path
        return memo[i][j] = triangle.get(i).get(j) + Math.min(down,downright);
    }
}
