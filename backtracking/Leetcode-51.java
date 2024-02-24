
// Tag - Hard

class Solution {
    public List<List<String>> solveNQueens(int n) {
        // create a result array list
        List<List<String>> list = new ArrayList();

        // initialize chess board with n x n
        char[][] chess = new char[n][n];

        // populate chess board with '.'
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                chess[i][j] = '.';
            }
        }

        // safeToPlaceQueen method fill the result list
        safeToPlaceQueen(list,chess,0);

        // return resultant list
        return list;
    }

    private void safeToPlaceQueen(List<List<String>> list, char[][] chess, int row){

        // if row reaches chess length add that row to list
        if(row == chess.length){
            // buildRow method converts chars to string
            list.add(build(chess));
            return;
        }

        // check for safe place to place queens
        for(int col=0; col<chess.length; col++){
            // isValidPosition checks for safe point on board
            if(isValidPosition(chess,row,col)){
                // if it is a safe point place 'Q'
                chess[row][col] = 'Q';
                // recursively call next row
                safeToPlaceQueen(list,chess,row+1);
                // set back to '.' for checking other possibilities
                chess[row][col] = '.';
            }
        }

    }

    private boolean isValidPosition(char[][] chess, int row, int col){

        // check for rows at col
        for(int i=0; i<row; i++){
            if(chess[i][col] == 'Q') return false;
        }

        // check for 45 deg diagonal
        for(int i=row-1, j=col+1; i>=0 && j<chess.length; i--, j++){
            if(chess[i][j] == 'Q') return false;
        }

        // check for 135 deg diagonal
        for(int i=row-1, j=col-1; i>=0 && j>=0; i--, j--){
            if(chess[i][j] == 'Q') return false;
        }

        // if none of the conditions met right place to place queen(valid)
        return true;
    }

    private List<String> build(char[][] chess){

        // list stores board chars in string format
        List<String> list = new ArrayList();

        // traverse each row
        for(int i=0; i<chess.length; i++){
            // convert to string and add to it list
            list.add(new String(chess[i]));
        }
        
        // returned list is later added to resultant list
        return list;
    }
}
