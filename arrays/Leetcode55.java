
// Tag - Medium
class Solution {
    public boolean canJump(int[] nums) {
        // Initialize the last reachable index to be the last index of the array.
        int lastIndex = nums.length - 1;
        
        // Iterate through the array from right to left.
        for (int i = nums.length - 2; i >= 0; i--) {
            // If the current position plus the maximum jump can reach or go beyond the last reachable index,
            // update the last reachable index to the current position.
            if (i + nums[i] >= lastIndex) {
                lastIndex = i;
            }
        }
        
        // Check if, after iterating through the array, the last reachable index is the first index (0).
        // If true, it means it's possible to reach the last index by jumping.
        return lastIndex == 0;
    }
}
