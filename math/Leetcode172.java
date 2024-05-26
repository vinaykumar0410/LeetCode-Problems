
// Tag - Medium
class Solution {
    public int trailingZeroes(int n) {
        // Base case: If n is 0, there are no trailing zeroes.
        if(n == 0) return 0;
        
        // Count trailing zeroes by recursively dividing by 5.
        return n/5 + trailingZeroes(n/5);
    }
}

/*
 class Solution {
    public int trailingZeroes(int n) {
        int count = 0;
        
        while(n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }
}
 */
