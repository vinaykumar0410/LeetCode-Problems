
class NumArray {
    // Declare an array to store the prefix sum.
    int[] preSum; 

    public NumArray(int[] nums) {
        // Assign the input array to the preSum array.
        preSum = nums; 

        // Calculate prefix sums.
        for (int i = 1; i < preSum.length; i++) {
            preSum[i] += preSum[i - 1];
        }
    }
    
    public int sumRange(int left, int right) {
        if (left == 0) // If left is 0, the sum is simply the value at right index.
            return preSum[right];
        else
            // by subtracting the prefix sum at 'left - 1' from the prefix sum at 'right'.
            return preSum[right] - preSum[left - 1];
    }
}
