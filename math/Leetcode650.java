
// Tag - Medium

class Solution {
    public int minSteps(int n) {
        // prime factorization method
        int cnt = 0;
        int denominator = 2;
        // do prime factorization only when n is greater than 1
        while(n > 1){
            // divide n & add prime factors to cnt until n is no more divisible
            while(n%denominator == 0){
                cnt += denominator;
                n /= denominator;
            }
            // try next denominator
            denominator++;
        }
        return cnt;
    }
}