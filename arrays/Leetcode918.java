
// Tag - Medium
class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int total = 0, maxSum = nums[0], curMax = 0, minSum = nums[0], curMin = 0;
        // Loop through the array.
        for (int num : nums) {
            // Calculate current maximum sum.
            curMax = Math.max(curMax + num, num);
            maxSum = Math.max(maxSum, curMax);
            // Calculate current minimum sum.
            curMin = Math.min(curMin + num, num);
            minSum = Math.min(minSum, curMin);
            // Calculate total sum.
            total += num;
        }
        // Return the maximum of either the maximum sum or the total sum minus the minimum sum.
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }
}
