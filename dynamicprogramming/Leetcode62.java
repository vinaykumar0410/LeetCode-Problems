
// Tag - Medium

// Recursion
class Solution {
    public int uniquePaths(int m, int n) {
        // base case
        if(m==1 || n==1){
            return 1;
        }
        // try all possible paths
        int left = uniquePaths(m-1,n);
        int right = uniquePaths(m,n-1);
        // return number of unique paths
        return left+right;
    }
}