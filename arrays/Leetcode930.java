
// Tag - Medium

class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        // Count the number of subarrays with sum equal to goal,
        // subtract the count of subarrays with sum equal to goal-1
        return helper(nums, goal) - helper(nums, goal - 1);
    }
    
    // Helper function to count the number of subarrays with sum equal to goal
    private int helper(int[] nums, int goal) {
        int sum = 0; // Initialize sum
        int start = 0; // Initialize start index
        int count = 0; // Initialize count of subarrays
        
        // Iterate through the array
        for (int end = 0; end < nums.length; end++) {
            sum += nums[end]; // Update sum
            
            // Adjust start index to maintain sum within target range
            while (sum > goal && start <= end) {
                sum -= nums[start++];
            }
            
            // Count subarrays with sum equal to goal
            count += (end - start + 1);
        }
        
        return count; // Return count of subarrays with sum equal to goal
    }
}
