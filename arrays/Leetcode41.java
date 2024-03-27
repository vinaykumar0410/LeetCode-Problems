
// Tag - Hard

class Solution {
    public int firstMissingPositive(int[] nums) {
        // Initialize index pointer
        int i = 0; 
        
        // Iterate through the array
        while (i < nums.length) {
            // Calculate the correct index for the current number
            int correct = nums[i] - 1; 
            
            // If current number is within range, positive, and not in its correct position, swap it
            if (nums[i] <= nums.length && nums[i] > 0 && nums[i] != nums[correct]) {
                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;
            } else {
                // Move to the next number if it's already in its correct position, negative, or out of range
                i++; 
            }
        }

        // Iterate through the array again to find the first missing positive integer
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != j + 1) {
                // Return the first missing positive integer
                return j + 1; 
            }
        }

        // If all positive integers up to nums.length are present, return the next positive integer
        return nums.length + 1; 
    }
}
