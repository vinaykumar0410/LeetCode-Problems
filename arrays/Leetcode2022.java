
// Tag - Easy

class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        // impossible to convert if we don't have m*n elements in original
        if(original.length != m*n){
            return new int[][]{};
        }
        int[][] ans = new int[m][n];
        int k = 0;
        // fill 2d array
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                ans[i][j] = original[k++];
            }
        }
        return ans;
    }
}