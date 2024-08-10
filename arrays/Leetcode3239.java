
// Tag - Medium

class Solution {
    public int minFlips(int[][] grid) {
        int rowCnt = 0;
        int colCnt = 0;

        // Count flips required for rows
        for(int[] row : grid) {
            StringBuilder str = new StringBuilder();
            for(int num : row) {
                str.append(num);
            }
            rowCnt += helper(str);
        }

        // Count flips required for columns
        for(int j = 0; j < grid[0].length; j++) {
            StringBuilder str = new StringBuilder();
            for(int i = 0; i < grid.length; i++) {
                str.append(grid[i][j]);
            }
            colCnt += helper(str);
        }

        // Return the minimum flips needed between rows and columns
        return Math.min(rowCnt, colCnt); 
    }

    // Helper function to count flips needed to make a string a palindrome
    private int helper(StringBuilder str) {
        int cnt = 0;
        int i = 0;
        int j = str.length() - 1;

        while(i < j) {
            // Count mismatches
            if(str.charAt(i) != str.charAt(j)) {
                cnt++; 
            }
            i++;
            j--;
        }

        return cnt;
    }
}
