
// Tag - Easy

// 0 1 1 2 4 7 13 ...(sum of prev 3 elements)
class Solution {
    public int tribonacci(int n) {
        // Base Condition
        if(n == 0) return 0;
        if(n < 3) return 1;
        // assign first 3 values manually
        int a = 0, b = 1, c = 1;
        // d holds output
        int d = 0;
        // start iteration from 3
        int i = 3;
        while(i++ <= n){
            // 3rd element would be 0th + 1st + 2nd element
            d = a+b+c;
            // update values
            a = b;
            b = c;
            c = d;
        }
        return d;
    }
}

/*
// TLE
class Solution {
    public int tribonacci(int n) {
        // Base Condition
        if(n == 0) return 0;
        if(n < 3) return 1;
        return tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3);
    }
}
*/