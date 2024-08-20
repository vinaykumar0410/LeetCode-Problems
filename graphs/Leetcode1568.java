
// Tag - Medium

class Solution {
    int m;
    int n;
    public int minDays(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        // initially check if grid is already disconnected
        if(islands(grid) != 1){
            return 0;
        }
        // try disconnecting single cell
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // found land mark it as water & check for islands
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(islands(grid) != 1){
                        return 1;
                    }
                    // try another cell
                    grid[i][j] = 1;
                }
            }
        }
        // can disconnect any grid in 2 days
        return 2;
    }
    // cnt the islands 
    private int islands(int[][] grid){
        int cnt = 0;
        // to avoid cycle
        boolean[][] vis = new boolean[m][n];
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // found land explore neighbors
                if(grid[i][j] == 1 && !vis[i][j]){
                    cnt++;
                    // dfs2(i,j,grid,vis);
                    // dfs1(i,j,grid,vis);
                    bfs(i,j,grid,vis);
                }
            }
        }
        return cnt;
    }
    // bfs to check neighbors
    private void bfs(int i,int j,int[][] grid,boolean[][] vis){
        Queue<int[]> q = new LinkedList();
        q.offer(new int[]{i,j});
        vis[i][j] = true;
        while(!q.isEmpty()){
            int[] pair = q.poll();
            int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
            for(int[] dir : dirs){
                int r = pair[0] + dir[0];
                int c = pair[1] + dir[1];
                if(isSafe(r,c) && grid[r][c] == 1 && !vis[r][c]){
                    q.offer(new int[]{r,c});
                    vis[r][c] = true;
                }
            }
        }
    }

    // dfs to check neighbors
    private void dfs1(int i,int j,int[][] grid,boolean[][] vis){
        if(i < 0 || i >= m || j < 0 || j >= n || grid[i][j] == 0 || vis[i][j]){
            return;
        }
        vis[i][j] = true;
        dfs1(i+1,j,grid,vis);
        dfs1(i-1,j,grid,vis);
        dfs1(i,j+1,grid,vis);
        dfs1(i,j-1,grid,vis);
    }

    // dfs to check neighbors
    private void dfs2(int i,int j,int[][] grid,boolean[][] vis){
        // mark it as visited
        vis[i][j] = true;
        // explore neighbors
        int[][] dirs = {{1,0},{-1,0},{0,-1},{0,1}};
        for(int[] dir : dirs){
            int r = i + dir[0];
            int c = j + dir[1];
            if(isSafe(r,c) && grid[r][c] == 1 && !vis[r][c]){
                dfs2(r,c,grid,vis);
            }
        }
    }
    // coordinates might go out of bounds
    private boolean isSafe(int r,int c){
        return r >= 0 && r < m && c >= 0 && c < n;
    }
}