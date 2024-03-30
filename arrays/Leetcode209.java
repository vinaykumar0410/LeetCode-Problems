
// Tag - Medium
class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        // Initialize variables.
        int min = Integer.MAX_VALUE; // Store the minimum length of subarray.
        int start = 0; // Start index of the current subarray.
        int sum = 0; // Sum of elements in the current subarray.

        // Iterate through the array.
        for(int end = 0; end < nums.length; end++){
            // Add the current element to the sum.
            sum += nums[end];
            
            // Check if the sum is greater than or equal to the target.
            while(sum >= target){  
                // Update the minimum length of subarray.
                min = Math.min(min, end - start + 1);
                // Move the start pointer to the right and update the sum accordingly.
                sum -= nums[start++];
            }
        }
        
        // If min is still Integer.MAX_VALUE, it means no subarray found, return 0, else return min.
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
