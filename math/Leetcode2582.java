
// Tag - Easy

class Solution {
    public int passThePillow(int n, int time) {
        int pillowPosition = 1;
        int passes  = 0;
        boolean forward = true;
        while(true){
            // base condition 
            if(passes == time) return pillowPosition; 
            // reached starting point time to move forward
            if(pillowPosition == 1) forward = true;
            // reached ending point time to move reverse
            if(pillowPosition == n) forward = false;
            if(forward) pillowPosition++;
            else pillowPosition--;
            passes++;
        }
    }
}