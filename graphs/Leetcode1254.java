
// Tag - Medium

class Solution {
    public int closedIsland(int[][] grid) {
        // cnt islands -> strictly 4 sides surrounded by 1(water)
        // land that is 0 on edges never form a closed island
        int n = grid.length;
        int m = grid[0].length;

        // pre-computation
        for(int r=0; r<n; r++){ // iterating on rows
            // changing 0th col and last col zeros to ones
            if(grid[r][0] == 0) dfs(r,0,n,m,grid);
            if(grid[r][m-1] == 0) dfs(r,m-1,n,m,grid);
        }
        for(int c=0; c<m; c++){ // iterating on cols
            // changing 0th row and last row zeros to ones
            if(grid[0][c] == 0) dfs(0,c,n,m,grid);
            if(grid[n-1][c] == 0) dfs(n-1,c,n,m,grid);
        }

        int closedIslands = 0;
        // traverse whole matrix
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                // found land -> make a dfs call on 4 sides
                if(grid[i][j] == 0){
                    closedIslands++;
                    dfs(i,j,n,m,grid);
                }
            }
        }

        return closedIslands;
    }

    private void dfs(int i, int j,int n,int m,int[][] grid){
        // mark it as 1 making land to water
        grid[i][j] = 1;
        // check all 4 sides 
        int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};
        for(int k=0; k<4; k++){
            int newi = i + dirs[k][0];
            int newj = j + dirs[k][1];
            // check for boundaries to avoid array index out of bounds
            if(isSafe(newi,newj,n,m) && grid[newi][newj] == 0){
                // call dfs on neighbors(top down left right)
                dfs(newi,newj,n,m,grid);
            }
        }
    }

    private boolean isSafe(int i,int j,int n,int m){
        return i>=0 && i<n && j>=0 && j<m;
    }
}