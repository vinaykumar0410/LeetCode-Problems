
// Tag - Medium

class Solution {
    public int nonSpecialCount(int l, int r) {
        int cnt = 0;
        for(int i=2; i*i<=r; i++){
            if(isPrime(i)){
                int sq = i*i;
                if(sq >= l && sq <= r){
                    cnt++;
                }
            }
        }
        return r-l+1-cnt;
    }
    boolean isPrime(int num){
        if(num < 2){
            return false;
        }
        for(int i=2; i*i<=num; i++){
            if(num%i==0){
                return false;
            }
        }
        return true;
    }
}