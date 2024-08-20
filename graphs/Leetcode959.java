
// Tag - Medium

class Solution {
    public int regionsBySlashes(String[] grid) {
        // convert slashes to 0s 1s matrix of nxn
        int n = grid.length;
        int[][] matrix = new int[n*3][n*3]; // n*2 doesn't works here

        // populate 0s 1s based on slashes
        for(int i=0; i<n; i++){
            char[] charArray = grid[i].toCharArray();
            for(int j=0; j<n; j++){
                if(charArray[j] == '/'){
                    matrix[i*3][j*3+2] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3] = 1;
                }else if(charArray[j] == '\\'){
                    matrix[i*3][j*3] = 1;
                    matrix[i*3+1][j*3+1] = 1;
                    matrix[i*3+2][j*3+2] = 1;
                }
            }
        }

        // run dfs on 0's 
        int regions = 0;
        for(int i=0; i<matrix.length; i++){
            for(int j=0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    dfs(i,j,matrix);
                    regions++;
                }
            }
        }
        return regions;
    }

    // basic dfs
    private void dfs(int i,int j,int[][] matrix){
        int n = matrix.length;
        if(i < 0 || j < 0 || i >= n || j >= n|| matrix[i][j] == 1){
            return;
        }
        matrix[i][j] = 1;
        dfs(i+1,j,matrix);
        dfs(i-1,j,matrix);
        dfs(i,j+1,matrix);
        dfs(i,j-1,matrix);
    }
}