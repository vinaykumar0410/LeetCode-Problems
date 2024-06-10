
// Tag - Easy

class Solution {
    public int numberOfChild(int n, int k) {
        int i = -1;
        boolean forward = true;
        while(k-->=0){
            if(i == n-1) forward = false;
            if(i == 0) forward = true;
            if(forward){
                i++;
            }else{
                i--;
            }
        }
        return i;
    }
}