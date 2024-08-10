
// Tag - Medium

class Solution {
    public int countPrimes(int n) {
        // base case (prime numbers starts with 2)
        if(n <= 1){
            return 0;
        } 
        // init a boolean array representing prime or not
        boolean[] primes = new boolean[n];
        // mark all numbers as true ie. prime
        Arrays.fill(primes,true);
        // mark 0 & 1 as false as they are not primes
        primes[0] = false;
        primes[1] = false;
        // checking srqt times of n is enough
        for(int i=2; i*i<n; i++){
            if(primes[i]){
                for(int j=i; j*i<n; j++){
                    // mark all multiples of 2 3 & 5
                    primes[j*i] = false;
                }
            }
        }
        int cnt = 0;
        // all non primes are marked as false
        for(int i=2; i<n; i++){
            if(primes[i]) cnt++;
        }
        return cnt;
    }
}