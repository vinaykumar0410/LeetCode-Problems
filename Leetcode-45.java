
// Tag - Medium
class Solution {
    public int jump(int[] nums) {
        // Initialize variables to track the minimum jumps, destination index, current coverage, and the last index of the jump.
        int minJumps = 0;
        int destination = nums.length - 1;
        int coverage = 0;
        int lastIndexJump = 0;

        // If the array has only one element, no jumps are needed, so return 0.
        if (nums.length == 1) return 0;

        // Iterate through the array to calculate the minimum jumps.
        for (int i = 0; i < nums.length; i++) {
            // Update the coverage to be the maximum of the current coverage and the sum of the current position and jump length.
            coverage = Math.max(coverage, i + nums[i]);

            // Check if the current position is equal to the last index of the previous jump.
            if (i == lastIndexJump) {
                // Update the last index of the jump, increment the minimum jumps.
                lastIndexJump = coverage;
                minJumps++;
                // Check if current coverage exceeds or equals destination return minimum jumps
                if (coverage >= destination) return minJumps;
            }
        }

        // Return the minimum number of jumps needed to reach the last index.
        return minJumps;
    }
}
