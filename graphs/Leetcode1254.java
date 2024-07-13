
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


/* BFS APPROACH */

class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length; // row length
        int n = grid[0].length; // col length

        // pre computation (convert border 0's to 1's using bfs)
        for(int i=0; i<m; i++){
            if(grid[i][0] == 0) bfs(i,0,m,n,grid);
            if(grid[i][n-1] == 0) bfs(i,n-1,m,n,grid);
        }

        for(int j=0; j<n; j++){
            if(grid[0][j] == 0) bfs(0,j,m,n,grid);
            if(grid[m-1][j] == 0) bfs(m-1,j,m,n,grid);
        }

        // go through entire matrix and count closed islands
        int closedIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // found land check neighbors using bfs
                if(grid[i][j] == 0){
                    bfs(i,j,m,n,grid);
                    closedIslands++;
                }
            }
        }

        return closedIslands;
    }

    // all four neighbors of current node
    int[][] dirs = {{0,1},{0,-1},{1,0},{-1,0}};

    // bfs function to check neighbors
    private void bfs(int i,int j,int m,int n,int[][] grid){
        Queue<int[]> q = new LinkedList();
        // add current node to q and mark it as 1(water) (visited)
        q.offer(new int[]{i,j});
        grid[i][j] = 1;
        while(!q.isEmpty()){
            int r = q.peek()[0];
            int c = q.peek()[1];
            // poll out current node as it was visited(marked as 1(water))
            q.poll();
            // check all neighbors
            for(int[] dir : dirs){
                int newr = r + dir[0];
                int newc = c + dir[1];
                // if current node is valid and found land
                if(isSafe(newr,newc,m,n) && grid[newr][newc] == 0){
                    // mark it as water and add it to queue
                    grid[newr][newc] = 1;
                    q.offer(new int[]{newr,newc});
                }
            }
        }
    }

    // isSafe function determines whether grid[i][j] is valid or not
    boolean isSafe(int i,int j,int m,int n){
        return i>=0 && i<m && j>=0 && j<n;
    }
}
