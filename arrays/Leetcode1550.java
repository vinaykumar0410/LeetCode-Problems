
// Tag - Easy

class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        // found 3 consecutive odds ? return true : return false
        int count = 0;
        for(int i:arr){
            if(i%2!=0){
                count++;
            }else{
                count=0;
            }
            if(count==3){
                return true;
            }
        }
        return false;
    }
}
