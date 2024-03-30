
// Tag - Hard
class Solution {
    public int subarraysWithKDistinct(int[] nums, int K) {
        // Utilize the principle of counting subarrays with at most K distinct elements
        // Subtract the count of subarrays with at most (K-1) distinct elements from the count of subarrays with at most K distinct elements
        return atMostK(nums, K) - atMostK(nums, K - 1);
    }
    
    private int atMostK(int[] nums, int K) {
        // Initialize variables
        int start = 0, cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        // Loop through the array
        for (int end = 0; end < nums.length; ++end) {
            // Update frequency of elements encountered
            map.put(nums[end], map.getOrDefault(nums[end], 0) + 1);
            // Adjust the window to maintain at most K distinct elements
            while (map.size() > K) {
                map.put(nums[start], map.get(nums[start]) - 1);
                if (map.get(nums[start]) == 0){
                    map.remove(nums[start]);
                } 
                start++;
            }
            // Accumulate the count of subarrays
            cnt += end - start;
        }
        // Return the count of subarrays with at most K distinct elements
        return cnt;
    }
}
