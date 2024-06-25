
// Tag - Medium

class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int start = 0;
        int window = 0;
        int maxWindow = 0;
        int satisfied = 0;
        for(int end = 0; end < grumpy.length; end++){
            if(grumpy[end] == 1){
                window += customers[end];
            }else{
                satisfied += customers[end];
            }
            if(end-start+1 > minutes){
                if(grumpy[start] == 1){
                    window -= customers[start];
                }
                start++;
            }
            maxWindow = Math.max(maxWindow,window);
        }
        return satisfied + maxWindow;
    }
}