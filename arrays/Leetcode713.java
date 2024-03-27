
// Tag - Medium
class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        // If k is less than or equal to 1, no subarray can have a product less than k
        if (k <= 1) return 0; 
        // Initialize count of subarrays with product less than k
        int count = 0; 
        // Initialize product of elements in the current window
        int product = 1; 
        // Initialize left pointer of the window
        int left = 0; 
        
        // Iterate through the array with a sliding window approach
        for (int right = 0; right < nums.length; right++) {
            // Update product with the new element
            product *= nums[right]; 
            
            // Shrink the window from the left as long as the product exceeds or equals k
            while (product >= k) {
                product /= nums[left];
                left++;
            }
            
            // Count the subarrays ending at the current right pointer and update the count
            count += right - left + 1; 
        }  
        
        // Return the total count of subarrays with product less than k
        return count; 
    }
}
