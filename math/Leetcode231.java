
// Tag - Easy
class Solution {
    public boolean isPowerOfTwo(int n) {
        // If n is 1, it is a power of two
        if (n == 1)
            return true;
        
        // If n is 0 or not divisible by 2, it can't be a power of two
        if (n == 0 || n % 2 != 0)
            return false; 
        
        // recursively call by dividing n by 2
        return isPowerOfTwo(n / 2);
    }
}
