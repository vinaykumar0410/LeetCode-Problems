
// Tag - Medium

class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        // directions
        int[][] dirs = {{0,1},{1,0},{0,-1},{-1,0}};
        int d=0,x=0,y=0,res=0;
        Set<String> deadends = new HashSet<>();
        for(int[] obstacle : obstacles) deadends.add(obstacle[0]+","+obstacle[1]);
        // process all commands
        for(int c : commands){
            if(c == -1){
                // rotate 90deg right (move to next dir in dirs)
                if(++d == 4){
                    d = 0;
                }
            }else if(c == -2){
                // rotate 90deg left (move to prev dir in dirs)
                if(--d == -1){
                    d = 3;
                }
            }else{
                // extract respective deviations
                int[] dir = dirs[d];
                int dx = dir[0], dy = dir[1];
                // move step by step & break if u find obstacle
                while(c-->0){
                    if(deadends.contains((x+dx)+","+(y+dy))){
                        break;
                    }
                    x += dx;
                    y += dy;
                }
            }
            // take out max from every command
            res = Math.max(res,(x*x)+(y*y));
        }
        return res;
    }
}