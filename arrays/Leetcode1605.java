
// Tag - Medium

class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        // Create a 2D array to store the result matrix
        int[][] ans = new int[rowSum.length][colSum.length];

        // Iterate through each row
        for (int i = 0; i < rowSum.length; i++) {
            // Iterate through each column
            for (int j = 0; j < colSum.length; j++) {
                // Set the element at (i, j) to the minimum of rowSum[i] and colSum[j]
                ans[i][j] = Math.min(rowSum[i], colSum[j]);

                // Subtract the value placed in ans[i][j] from rowSum[i] and colSum[j]
                rowSum[i] -= ans[i][j];
                colSum[j] -= ans[i][j];
            }
        }

        // Return the constructed matrix
        return ans;
    }
}
