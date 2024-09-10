
// Tag - Medium

// dfs
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        // subIslands keeps track of valid subIslands
        int subIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // found land explore neighbors
                if(grid2[i][j] == 1){
                    isAPartOfIsland = true;
                    dfs(grid1,grid2,i,j,m,n);
                    if(isAPartOfIsland) subIslands++;
                }
            }
        }
        return subIslands;
    }
    boolean isAPartOfIsland = false;
    private void dfs(int[][] grid1,int[][] grid2,int i,int j,int m,int n){
        // invalid base cases
        if(i < 0 || i >= m || j < 0 || j >= n || grid2[i][j] == 0){
            return;
        }
        // found water in grid1 -> not part of island
        if(grid1[i][j] == 0){
            isAPartOfIsland = false;
            return;
        }
        // else both grids are land so mark grid2 as 0 (water or visited)
        grid2[i][j] = 0;
        // explore all neighbors
        dfs(grid1,grid2,i+1,j,m,n);
        dfs(grid1,grid2,i-1,j,m,n);
        dfs(grid1,grid2,i,j+1,m,n);
        dfs(grid1,grid2,i,j-1,m,n);
    }
}


// bfs
class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length;
        int n = grid1[0].length;
        // subIslands keeps track of valid subIslands
        int subIslands = 0;
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                // found land explore neighbors
                if(grid2[i][j] == 1){
                    boolean isAPartOfIsland = true;
                    // init queue & add current cell to queue & mark it as 0 (visited)
                    Queue<int[]> q = new LinkedList();
                    q.offer(new int[]{i,j});
                    grid2[i][j] = 0;
                    while(!q.isEmpty()){
                        // poll out current cell
                        int[] pair = q.poll();
                        int x = pair[0];
                        int y = pair[1];
                        // if current cell which is land in grid2 is water in grid1 -> not part of subIsland
                        if(grid1[x][y] == 0){
                            isAPartOfIsland = false;
                        }
                        // else part of subIsland explore all neighbors
                        int[][] dirs = {{1,0},{-1,0},{0,1},{0,-1}};
                        for(int[] dir : dirs){
                            int newX = x + dir[0];
                            int newY = y + dir[1];
                            // valid base case to process further
                            if(newX >= 0 && newX < m && newY >=0 && newY < n && grid2[newX][newY] == 1){
                                grid2[newX][newY] = 0;
                                q.offer(new int[]{newX,newY});
                            }
                        }
                    }
                    if(isAPartOfIsland) subIslands++;
                }
            }
        }
        return subIslands;
    }
}