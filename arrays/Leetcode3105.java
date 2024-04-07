
// Tag - Easy
class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        // Initialize the maximum length of the monotonic subarray
        int maxLength = 1; 
        // If there's only one element, return 1
        if (nums.length == 1) return maxLength; 
        
        int increasing = 1; // Initialize the length of the current increasing subarray
        int decreasing = 1; // Initialize the length of the current decreasing subarray
        
        // Iterate through the array starting from the second element
        for (int i = 1; i < nums.length; i++) {
            // If the current element is greater than the previous one, it's part of an increasing subarray
            if (nums[i] > nums[i - 1]) {
                increasing++; // Increment the length of the increasing subarray
                decreasing = 1; // Reset the length of the decreasing subarray to 1
            } 
            // If the current element is less than the previous one, it's part of a decreasing subarray
            else if (nums[i] < nums[i - 1]) {
                decreasing++; // Increment the length of the decreasing subarray
                increasing = 1; // Reset the length of the increasing subarray to 1
            } 
            // If the current element is equal to the previous one, reset both increasing and decreasing lengths to 1
            else {
                increasing = 1;
                decreasing = 1;
            }
            
            // Update the maximum length with the maximum of increasing and decreasing lengths
            maxLength = Math.max(maxLength, Math.max(increasing, decreasing));
        }
        
        // Return the maximum length of the monotonic subarray
        return maxLength; 
    }
}
