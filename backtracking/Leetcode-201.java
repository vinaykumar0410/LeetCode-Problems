
// Tag - Medium
class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        // Loop until 'right' is greater than 'left'
        while(right > left){
            // Perform bitwise AND of 'right' and 'right - 1'
            right = right & (right - 1);
        }
        
        // Return the bitwise AND of 'left' and 'right'
        return left & right;
    }
}

