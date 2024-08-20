
// Tag - Medium

class Solution {
    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        
        // Iterate over possible starting points for subsequence
        for (int i = 0; i <= n - k; i++) {
            boolean found = true;
            int max = nums[i];
            
            // Check if the current subsequence is strictly increasing
            for (int j = i + 1; j < i + k; j++) {
                if (nums[j] <= nums[j - 1]) {
                    found = false;
                    break;
                }
                max = Math.max(max, nums[j]);
            }
            
            // Check if the difference between max and min equals k-1
            if (found) {
                int min = nums[i];
                int diff = max - min;
                ans[i] = (diff == k - 1) ? max : -1;
            } else {
                ans[i] = -1; // Mark invalid subsequence
            }
        }
        return ans;
    }
}
