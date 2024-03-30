
// Tag - Medium
class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        // Map to store the frequency of numbers encountered
        Map<Integer,Integer> map = new HashMap();
        // Initialize the starting index of the subarray
        int start = 0;
        // Initialize the maximum length of subarray
        int maxLength = 0;
        // Loop through the array
        for(int end = 0; end < nums.length; end++){
            // Update the frequency of the current number
            int rightKey = nums[end];
            map.put(rightKey,map.getOrDefault(rightKey,0)+1);
            // Adjust the subarray to ensure the sum is less than or equal to k
            while(map.get(rightKey) > k){
                // Remove elements from the left until the sum is valid
                int leftKey = nums[start++];
                map.put(leftKey,map.get(leftKey)-1);
                if(map.get(leftKey) == 0) map.remove(leftKey);
            }
            // Update the maximum length
            maxLength=Math.max(maxLength,end-start+1);
        }
        // Return the maximum length of subarray
        return maxLength;
    }
}

