
// Tag - Medium

/*
// Brute Force Approach
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        // Iterate through each element in the array
        for(int i = 0; i < nums.length; i++) {
            int prod = 1;
            // Multiply all elements except the current element
            for(int j = 0; j < nums.length; j++) {
                if(i != j) {
                    prod *= nums[j];
                }
            }
            arr[i] = prod; // Store product in the result array
        }
        return arr; // Return result array
    }
}
*/

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        // Initialize product
        int prod = 1; 
        // Forward pass: calculate product of elements to the left of each element
        for(int i = 0; i < nums.length; i++) {
            arr[i] = prod; // Store product in the result array
            prod *= nums[i]; // Update product
        }
        // Reset product
        prod = 1; 
        // Backward pass: multiply product with elements to the right of each element
        for(int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= prod; // Update result array with product of elements to the right
            prod *= nums[i]; // Update product
        }
        return arr; // Return result array
    }
}

