
// Tag - Easy

class Solution {
    public List<Integer> luckyNumbers(int[][] matrix) {
        List<Integer> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        // Loop through each row to find the minimum values and add them to the set
        for (int i = 0; i < m; i++) {
            set.add(getMin(matrix, i));
        }
        
        // Loop through each column to find the maximum values
        for (int j = 0; j < n; j++) {
            int max = getMax(matrix, j);
            // If max value is already in the set, it's a lucky number
            if (!set.add(max)) {
                list.add(max);
            }
        }
        
        return list;
    }
    
    // Helper method to get the minimum value in a specific row
    private int getMin(int[][] matrix, int row) {
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < matrix[0].length; j++) {
            if (matrix[row][j] < min) {
                min = matrix[row][j];
            }
        }
        return min;
    }
    
    // Helper method to get the maximum value in a specific column
    private int getMax(int[][] matrix, int col) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][col] > max) {
                max = matrix[i][col];
            }
        }
        return max;
    }
}
