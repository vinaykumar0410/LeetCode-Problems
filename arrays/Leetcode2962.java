
// Tag - Medium

public class Solution {
    public long countSubarrays(int[] nums, int k) {
        // Find the maximum element in the array
        int max = Arrays.stream(nums).max().getAsInt();
        // Initialize variables
        int length = nums.length, cnt = 0, start = 0;
        long ans = 0;
        // Loop through the array
        for(int end = 0; end < length; ++end) {
            // Increment count if the current element is the maximum
            cnt += nums[end] == max ? 1 : 0;
            // Adjust start index to maintain the count less than k
            while (cnt >= k)
                cnt -= nums[start++] == max ? 1 : 0;
            // Accumulate the number of subarrays
            ans += start;
        }
        // Return the total count of subarrays
        return ans;
    }
}
