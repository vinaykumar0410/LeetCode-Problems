
// Tag - Easy

class neighborSum {
    int[][] matrix;
    int n = 0;

    // Constructor to initialize the matrix with given grid
    public neighborSum(int[][] grid) {
        n = grid.length;
        matrix = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                matrix[i][j] = grid[i][j]; // Copy grid to matrix
            }
        }
    }
    
    // Method to calculate the sum of adjacent (up, down, left, right) cells with a specific value
    public int adjacentSum(int value) {
        int sum = 0;
        // Directions for adjacent cells
        int[][] dirs = {{0,1},{0,-1},{-1,0},{1,0}}; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == value){
                    for(int[] dir : dirs){
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if(r < n && r >= 0 && c < n && c >= 0){
                            // Add value of adjacent cells
                            sum += matrix[r][c]; 
                        }
                    }
                }
            }
        }
        return sum;
    }
    
    // Method to calculate the sum of diagonal cells with a specific value
    public int diagonalSum(int value) {
        int sum = 0;
        // Directions for diagonal cells
        int[][] dirs = {{-1,-1},{-1,1},{1,-1},{1,1}}; 
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(matrix[i][j] == value){
                    for(int[] dir : dirs){
                        int r = i + dir[0];
                        int c = j + dir[1];
                        if(r < n && r >= 0 && c < n && c >= 0){
                            // Add value of diagonal cells
                            sum += matrix[r][c]; 
                        }
                    }
                }
            }
        }
        return sum;
    }
}

/**
 * Your neighborSum object will be instantiated and called as such:
 * neighborSum obj = new neighborSum(grid);
 * int param_1 = obj.adjacentSum(value);
 * int param_2 = obj.diagonalSum(value);
 */

