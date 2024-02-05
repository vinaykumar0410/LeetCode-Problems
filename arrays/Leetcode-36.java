
// Tag - Medium

class Solution {
    public boolean isValidSudoku(char[][] board) {

        // Set to store unique representations of numbers in rows, columns, and sub-boxes
        Set<String> set = new HashSet();

        // Iterate through each cell in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                
                // Retrieve the character at the current cell
                char ch = board[i][j];

                // Check if the character is not empty ('.')
                if (ch != '.') {
                    // Create unique representations for the current number in rows, columns, and sub-boxes
                    // and add them to the set
                    // If any representation is already in the set, return false (not a valid Sudoku)
                    if (!set.add(ch + " row " + i) ||
                        !set.add(ch + " col " + j) ||
                        !set.add(ch + " sub-boxes " + i / 3 + "-" + j / 3)
                    ) {
                        return false;
                    }
                }
            }
        }

        // If no conflicts are found, the Sudoku board is valid
        return true;
    }
}